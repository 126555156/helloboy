package com.hwx.dao;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.hwx.returnInfo.UserInfo;

@Service
public class HelloBoyDao {
	// @Autowired
	// private HelloBoyJdbc helloBoyJdbc;
	@Autowired
	public UserInfo userInfo;
	// @Autowired
	// public UserInfo dataSource;
	// @Autowired
	// private ComboPooledDataSource dataSource;
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int login(String username, String password) {
		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// String sql = "select * from userinfo where username =? and
		// password=?";
		try {
			// System.out.println("开始查询用户数据");
			// org.hibernate.query.Query query = hibernateTemplate.;
			// List<personal> list = query.list();
			// for (personal personal : list) {
			// System.out.println(personal);
			// }
			// Map<String, Object> map = jdbcTemplate.queryForMap(sql, username,
			// password);
			// System.out.println("查询到数据:" + map);
			// userInfo.setUsername(username);
			// userInfo.setPassword(password);
			// userInfo.setId((int) map.get("iduserInfo"));
			// userInfo.setEmail((String) map.get("email"));
			// userInfo.setLevel((String) map.get("level"));
			// userInfo.setNickname((String) map.get("nickname"));
			// userInfo.setIslogin(1);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常了" + e);
			return 0;
		}
	}

	public int adduser(String username, String password, String nickname) {
		int row;
		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		// String sql = "insert into userinfo(username,password,nickname)
		// values(?,?,?)";
		// String sql1 = "select * from userinfo where username = ?";
		try {
			userInfo.setUsername(username);
			userInfo.setPassword(password);
			userInfo.setNickname(nickname);
			System.out.println("开始插入数据");
			hibernateTemplate.save(userInfo);
			userInfo.setIslogin(1);
			// row = jdbcTemplate.update(sql, username, password, nickname);
			// System.out.println("插入" + row);
			// Map<String, Object> map = jdbcTemplate.queryForMap(sql1,
			// username);
			// System.out.println("查询到数据:" + map);
			// userInfo.setId((int) map.get("iduserInfo"));
			// userInfo.setLevel((String) map.get("level"));
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("到底是什么"+e);
			return 0;
		}
	}

}
