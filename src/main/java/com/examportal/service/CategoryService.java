package com.examportal.service;

import java.util.Set;

import com.examportal.model.exam.Category;

public interface CategoryService {
	//Add Category
    public Category addCategory(Category category);
    //Update Category
    public Category updateCategory(Category category);
    //Get All Category
    public Set<Category> getCategories();
    //Get Singal Category
    public Category getCategory(Long cId);
    //Get Category By Id
    public void deleteCategory(Long cId);
}
