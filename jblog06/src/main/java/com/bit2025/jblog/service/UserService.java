package com.bit2025.jblog.service;

import com.bit2025.jblog.repository.BlogRepository;
import com.bit2025.jblog.repository.CategoryRepository;
import com.bit2025.jblog.vo.BlogVo;
import com.bit2025.jblog.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bit2025.jblog.repository.UserRepository;
import com.bit2025.jblog.vo.UserVo;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public void join(UserVo userVo) {
		String password = userVo.getPassword();
		String passwordEnc = passwordEncoder.encode(password);
		userVo.setPassword(passwordEnc);

		// 1. 사용자 정보 저장 (user)
		userRepository.insert(userVo);

		// 2. default blog 생성 (blog)
		BlogVo blogVo = new BlogVo();
		blogVo.setBlogId(userVo.getId());
		blogVo.setTitle(userVo.getId() + "님의 블로그");
		blogVo.setProfile("/assets/upload-images/spring-logo.jpg");
		blogRepository.insert(blogVo);

		// 3. default category 생성 (category)
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName("미분류");
		categoryVo.setDescription("기본으로 생성되는 카테고리입니다. ");
		categoryVo.setBlogId(blogVo.getBlogId());
		categoryRepository.insert(categoryVo);
	}
}
