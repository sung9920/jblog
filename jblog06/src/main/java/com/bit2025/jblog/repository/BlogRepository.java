package com.bit2025.jblog.repository;

import com.bit2025.jblog.security.UserDetailsImpl;
import com.bit2025.jblog.vo.BlogVo;
import com.bit2025.jblog.vo.UserVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;

	public int insert(BlogVo blogVo) {
		return sqlSession.insert("blog.insert", blogVo);
	}

}
