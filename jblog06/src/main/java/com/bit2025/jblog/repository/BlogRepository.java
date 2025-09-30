package com.bit2025.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2025.jblog.vo.BlogVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;

	public int insert(BlogVo blogVo) {
		return sqlSession.insert("blog.insert", blogVo);
	}

	public BlogVo findById(String blogId) {
		return sqlSession.selectOne("blog.findById", blogId);
	}

	public int update(BlogVo blogvo) {
		return sqlSession.update("blog.update",blogvo);
	}

}
