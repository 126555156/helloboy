package com.hwx.returnInfo;

import org.springframework.stereotype.Controller;

@Controller
public class Result<T> {
	public int code;
	public String message;
	public T data;
}
