package com.hwx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwx.dao.HelloBoyDao;
import com.hwx.dao.UserInfoDaoImpl;
import com.hwx.returnInfo.Result;
import com.hwx.returnInfo.UserInfo;

@Transactional
@Service
public class HelloBoyService {
	@Autowired
	private Result<UserInfo> resultuser;
	@Autowired
	private UserInfoDaoImpl userInfoDaoImpl;
	@Autowired
	private UserInfo userInfo;
	private UserInfo userInfo1;

	public Result<UserInfo> login(String username, String password) {
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo1=userInfoDaoImpl.findlogin(userInfo);
		if (userInfo1!=null) {
			userInfo1.setIslogin(1);	
			resultuser.message = "登录成功";
			resultuser.code = 0;
			resultuser.data = userInfo1;
		} else {
			resultuser.message = "用户名或密码错误";
			resultuser.code = 1;
			resultuser.data = null;
		}
		return resultuser;
	}

	public Result<UserInfo> register(String username, String password, String nickname) {
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setNickname(nickname);
		userInfo1=userInfoDaoImpl.findregister(userInfo);
		System.out.println(userInfo.toString());
		if (userInfo1==null) {
			userInfoDaoImpl.save(userInfo);
			userInfo.setIslogin(1);
			resultuser.message = "注册成功";
			resultuser.code = 0;
			resultuser.data = userInfo;
		} else {
			resultuser.message = "该用户已被注册";
			resultuser.code = 1;
			resultuser.data = null;
		}

		return resultuser;
	}

	public Result<UserInfo> exit() {
		resultuser.message = "退出登录成功";
		resultuser.code = 0;
		resultuser.data = null;
		return resultuser;
	}

	public Result<UserInfo> initialize() {
		resultuser.message = "登录信息已过期请重新登录";
		resultuser.code = 1;
		resultuser.data = null;
		return resultuser;
	}
}
