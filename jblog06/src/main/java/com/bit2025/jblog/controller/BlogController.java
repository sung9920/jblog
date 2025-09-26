package com.bit2025.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@RequestMapping("/main")
	public String blogMain() {
		return "blog/main";
	}
}
