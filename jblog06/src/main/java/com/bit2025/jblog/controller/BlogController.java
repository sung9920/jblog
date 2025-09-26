package com.bit2025.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{blogId:^(?!assets).*$}")
public class BlogController {

    @GetMapping({ "", "/", "/{categoryId}", "/{categoryId}/{postId}" })
    public String main(
            @PathVariable("blogId") String blogId,
            @PathVariable(value = "categoryId", required = false) Long categoryId,
            @PathVariable(value = "postId", required = false) Long postId) {

        if (categoryId == null) {
        	System.out.println("set default categoryId, default postId");
        } else if (postId == null) {
        	System.out.println("set default postId");
        }

    	return "blog/main";
    }

}