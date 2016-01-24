package com.ricky.codelab.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("login")
	public String login(){
		System.out.println("login");
		return "login";
	}
	
	@RequestMapping("helloworld")
	public String hello(){
		System.out.println("hello world");
		return "success";
	}
}
