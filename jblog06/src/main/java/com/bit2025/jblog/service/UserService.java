package com.bit2025.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bit2025.jblog.repository.UserRepository;
import com.bit2025.jblog.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void join(UserVo userVo) {
		String password = userVo.getPassword();
		String passwordEnc = passwordEncoder.encode(password);
		userVo.setPassword(passwordEnc);

		userRepository.insert(userVo);
	}
}
