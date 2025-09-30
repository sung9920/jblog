package com.bit2025.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2025.jblog.vo.PostVo;

@Repository
public class PostRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<PostVo> findByCategoryId(Long categoryId) {
		return sqlSession.selectList("post.findByCategoryId", categoryId);
	}

	public PostVo findByPostId(Long postId) {
		return sqlSession.selectOne("post.findByPostId", postId);
	}

	public int insert(PostVo postVo) {
		return sqlSession.insert("post.insert", postVo);
	}

}
