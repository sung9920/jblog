package com.bit2025.jblog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2025.jblog.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;

    @RequestMapping({"/", "/main"})
    public String index(Model model) {
    	model.addAttribute("userVo", userService.getUser());
        return "main/index";
    }
}
