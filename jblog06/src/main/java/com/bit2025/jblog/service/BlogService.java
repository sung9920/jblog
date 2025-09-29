package com.bit2025.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2025.jblog.repository.BlogRepository;
import com.bit2025.jblog.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;

	public BlogVo getContents(String blogId) {
		BlogVo blogVo = blogRepository.findById(blogId);

		return blogVo;
	}

}
