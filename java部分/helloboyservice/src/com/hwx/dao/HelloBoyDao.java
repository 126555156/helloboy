package com.hwx.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;

import com.hwx.returnInfo.UserInfo;

@Service
public class HelloBoyDao {
	@Autowired
	private HelloBoyJdbc helloBoyJdbc;
	@Autowired
	public UserInfo userInfo;
	public int login(String username, String password) {
		System.out.println("开始查询用户数据");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(helloBoyJdbc.dataSource);
		String sql = "select * from userinfo where username =? and password=?";
		try {
			Map<String, Object> map = jdbcTemplate.queryForMap(sql, username,password);
			System.out.println("查询到数据:" + map);
			userInfo.setUsername(username);
			userInfo.setPassword(password);
			userInfo.setId((int) map.get("iduserInfo"));
			userInfo.setEmail((String) map.get("email"));
			userInfo.setLevel((String) map.get("level"));
			userInfo.setNickname((String) map.get("nickname"));
			userInfo.setIslogin(1);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常了"+e);
			return 0;
		}
	}
	public int adduser(String username, String password,String nickname) {
		int row;
		System.out.println("开始插入数据");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(helloBoyJdbc.dataSource);
		String sql = "insert into userinfo(username,password,nickname) values(?,?,?)";
		String sql1 = "select * from userinfo where username = ?";
		try {
			row = jdbcTemplate.update(sql, username, password,nickname);
			System.out.println("插入" + row);
			Map<String, Object> map = jdbcTemplate.queryForMap(sql1, username);
			System.out.println("查询到数据:" + map);
			userInfo.setUsername(username);
			userInfo.setPassword(password);
			userInfo.setNickname(nickname);
			userInfo.setId((int) map.get("iduserInfo"));
			userInfo.setLevel((String) map.get("level"));
			userInfo.setIslogin(1);
			return row;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

}
