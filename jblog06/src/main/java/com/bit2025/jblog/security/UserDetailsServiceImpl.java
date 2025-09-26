package com.bit2025.jblog.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bit2025.jblog.repository.UserRepository;
import com.bit2025.jblog.vo.UserVo;

public class UserDetailsServiceImpl implements UserDetailsService {
	private UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	return userRepository.findByName(username);
    }
}
