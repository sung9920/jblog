package com.bit2025.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2025.jblog.vo.CategoryVo;
import com.bit2025.jblog.vo.UserVo;

@Repository
public class CategoryRepository {

	@Autowired
	private SqlSession sqlSession;

	public int insert(CategoryVo categoryVo) {
		return sqlSession.insert("category.insert", categoryVo);
	}

	public List<CategoryVo> findById(String blogId) {
		return sqlSession.selectList("category.findById", blogId);
	}

	public int delete(Long categoryId) {
		return sqlSession.delete("category.delete", categoryId);
	}

}
