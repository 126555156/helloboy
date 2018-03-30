package com.hwx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hwx.returnInfo.Result;
import com.hwx.returnInfo.UserInfo;
@Controller
public class HelloBoyCheck {
	@Autowired
	private Result<UserInfo> resultuser;
	public Result<UserInfo> checkLogin(String username, String password) {
		System.out.println(username+"........"+password);
		if(username==""){
			resultuser.message="用户名不能为空";
			resultuser.code=1;
			resultuser.data=null;
		}else if(password==""){
			resultuser.message="密码不能为空";
			resultuser.code=1;
			resultuser.data=null;
		}else {
			resultuser.code=0;
		}
		return resultuser;
	}
	public Result<UserInfo> checkRegister(String username, String password, String nickname) {
		if(nickname==""){
			resultuser.message="昵称不能为空";
			resultuser.code=1;
			resultuser.data=null;
		}else if(username==""){
			resultuser.message="用户名不能为空";
			resultuser.code=1;
			resultuser.data=null;
		}else if(password==""){
			resultuser.message="密码不能为空";
			resultuser.code=1;
			resultuser.data=null;
		}else {
			resultuser.code=0;
		}
		return resultuser;
	}
}
