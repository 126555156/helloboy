package com.hwx.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

@Controller
public class AddHeader {
	public HttpServletResponse add(HttpServletResponse response) {
		System.out.println("开始加头信息");
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8010");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    	response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Max-Age", "3600");
		response.setContentType("application/json;charset=utf-8");
		return response;
	}
}
