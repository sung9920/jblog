package com.bit2025.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2025.jblog.service.BlogService;
import com.bit2025.jblog.service.CategoryService;
import com.bit2025.jblog.service.PostService;
import com.bit2025.jblog.vo.BlogVo;
import com.bit2025.jblog.vo.CategoryVo;
import com.bit2025.jblog.vo.PostVo;

@Controller
@RequestMapping("/{blogId}/admin")
public class AdminController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private PostService postService;

    @GetMapping("/basic")
    public String basic(
    		Model model,
            @PathVariable("blogId") String blogId) {

    	BlogVo blogVo = blogService.getContents(blogId);
    	model.addAttribute("blogVo", blogVo);

    	List<CategoryVo> categoryVo = categoryService.getList(blogId);
    	model.addAttribute("categoryList", categoryVo);

    	return "blog/admin-basic";
    }

}