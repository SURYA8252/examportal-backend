package com.examportal.service.implement;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.exam.Category;
import com.examportal.repository.CategoryRepository;
import com.examportal.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category addCategory(Category category) {
		//save Category
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		//Update Category
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		//get all Category
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long cId) {
		// getSingal Category
		return this.categoryRepository.findById(cId).get();
	}

	@Override
	public void deleteCategory(Long cId) {
		//Delete by Id category
		Category category = new Category();
		category.setcId(cId);
		this.categoryRepository.deleteById(cId);
		
	}

}
