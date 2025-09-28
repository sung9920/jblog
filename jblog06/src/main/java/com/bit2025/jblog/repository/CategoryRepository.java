package com.bit2025.jblog.repository;

import com.bit2025.jblog.security.UserDetailsImpl;
import com.bit2025.jblog.vo.CategoryVo;
import com.bit2025.jblog.vo.UserVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CategoryRepository {

	@Autowired
	private SqlSession sqlSession;

	public int insert(CategoryVo categoryVo) {
		return sqlSession.insert("category.insert", categoryVo);
	}

}
