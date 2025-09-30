package com.bit2025.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2025.jblog.service.BlogService;
import com.bit2025.jblog.service.CategoryService;
import com.bit2025.jblog.service.FileuploadService;
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

	@Autowired
	private FileuploadService fileuploadService;

    @ModelAttribute("blogVo")
    public BlogVo blogVo(@PathVariable("blogId") String blogId) {
        return blogService.getContents(blogId);
    }

    @RequestMapping("/basic")
    public String basic() {
    	return "blog/admin-basic";
    }

    @RequestMapping("/update")
    public String basic(
    		BlogVo blogvo,
    		@PathVariable("blogId") String blogId,
    		@RequestParam("file") MultipartFile multipartFile) {
    	String profile = fileuploadService.restore(multipartFile);

		if(profile != null) {
			blogvo.setProfile(profile);
		}

		blogService.updateBlog(blogvo);

    	return "redirect:/" + blogId + "/admin/basic";
    }

    @RequestMapping(value="/category", method=RequestMethod.GET)
    public String category(
    		Model model,
            @PathVariable("blogId") String blogId) {

    	List<CategoryVo> categoryVo = categoryService.getList(blogId);
    	model.addAttribute("categoryList", categoryVo);

    	return "blog/admin-category";
    }

    @RequestMapping(value="/category", method=RequestMethod.POST)
    public String category(
    		@ModelAttribute CategoryVo categoryVo,
    		@PathVariable("blogId") String blogId) {
    	categoryVo.setBlogId(blogId);
    	categoryService.addCategory(categoryVo);
    	return "redirect:/" + blogId + "/admin/category";
    }

    @RequestMapping("/delete/{id}")
    public String delete(
    		@PathVariable("blogId") String blogId,
    		@PathVariable("id") Long categoryId) {
    	categoryService.delCategory(categoryId);
    	return "redirect:/" + blogId + "/admin/category";
    }


    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String write(
    		Model model,
            @PathVariable("blogId") String blogId) {

    	List<CategoryVo> categoryVo = categoryService.getList(blogId);
    	model.addAttribute("categoryList", categoryVo);

    	return "blog/admin-write";
    }

    @RequestMapping(value="/write", method=RequestMethod.POST)
    public String write(
    		@ModelAttribute PostVo postVo,
            @PathVariable("blogId") String blogId) {

    	postService.addPost(postVo);
    	return "redirect:/" + blogId + "/admin/write";
    }

}