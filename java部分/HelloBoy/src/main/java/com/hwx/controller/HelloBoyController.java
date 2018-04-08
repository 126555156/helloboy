package com.hwx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.hwx.service.HelloBoyService;

//@CrossOrigin(origins = "http://localhost:8010", maxAge = 3600)
// @Controller
@RestController
@RequestMapping(value = "/", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
public class HelloBoyController {
	@Autowired
	private HelloBoyService helloBoyService;
	@Autowired
	private HelloBoyCheck helloBoyCheck;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
//	@Autowired
//	private hhhh zzz;

	@RequestMapping("/")
	public String index(Model model) {
		System.out.println("index");
		// 转到helloworld.jsp
		return "index";
	}

	@RequestMapping(value = "initialize")
	String initialize(@RequestParam("password") String password, @RequestParam("username") String username) {
		System.out.println("前端来数据了");
		System.out.println("账号：" + username);
		System.out.println("密码：" + password);
		HttpSession session = request.getSession();
		if (!session.isNew()) {
			String returnInfo = (String) session.getAttribute("userInfo");
			System.out.println("已有session直接返回:" + returnInfo);
			return returnInfo;
		}
		return null;
	}

	@RequestMapping(value = "login")
	String login(@RequestParam("password") String password, @RequestParam("username") String username) {
		System.out.println("前端来数据了");
		System.out.println("账号：" + username);
		System.out.println("密码：" + password);
		// 使用request对象的getSession()获取session，如果session不存在则创建一个
		HttpSession session = request.getSession();
		Gson gson = new Gson();
		if (helloBoyCheck.checkLogin(username, password).code == 1) {
			String returnInfo = gson.toJson(helloBoyCheck.checkLogin(username, password));
			return returnInfo;
		}
		String returnInfo = gson.toJson(helloBoyService.login(username, password));
		System.out.println("返回数据了:" + returnInfo);
		// 将数据存储到session中
		session.setAttribute("userInfo", returnInfo);
		return returnInfo;
	}

	@RequestMapping(value = "register")
	String register(@RequestParam("password") String password, @RequestParam("username") String username,
			@RequestParam("nickname") String nickname) {
		System.out.println("前端来数据了");
		System.out.println("昵称：" + nickname);
		System.out.println("账号：" + username);
		System.out.println("密码：" + password);
		Gson gson = new Gson();
		if (helloBoyCheck.checkRegister(username, password, nickname).code == 1) {
			String returnInfo = gson.toJson(helloBoyCheck.checkRegister(username, password, nickname));
			return returnInfo;
		}
		String returnInfo = gson.toJson(helloBoyService.register(username, password, nickname));
		System.out.println("返回数据了:" + returnInfo);
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", returnInfo);
		return returnInfo;
	}

	@RequestMapping(value = "exit")
	String exit() {
		System.out.println("准备退出");
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		String returnInfo = gson.toJson(helloBoyService.exit());
		session.invalidate();
		System.out.println("返回数据了:" + returnInfo);
		return returnInfo;
	}
}
