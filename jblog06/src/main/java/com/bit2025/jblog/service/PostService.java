package com.bit2025.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2025.jblog.repository.PostRepository;
import com.bit2025.jblog.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	public List<PostVo> getList(Long categoryId) {
		return postRepository.findById(categoryId);
	}

}
