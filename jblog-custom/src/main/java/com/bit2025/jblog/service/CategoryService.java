package com.bit2025.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2025.jblog.repository.CategoryRepository;
import com.bit2025.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryVo> getList(String blogId) {
		return categoryRepository.findById(blogId);
	}

	public void addCategory(CategoryVo categoryVo) {
		categoryRepository.insert(categoryVo);
	}

	public void delCategory(Long categoryId) {
		categoryRepository.delete(categoryId);
	}

}
