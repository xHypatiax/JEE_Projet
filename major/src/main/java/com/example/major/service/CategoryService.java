package com.example.major.service;

import com.example.major.model.Category;
import com.example.major.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository ;
    private List<Category> categoryList;

    public List<Category> getAllCategory(){

        return categoryRepository.findAll();
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void removeCategoryById(int id){
        categoryRepository.deleteById(id);
    }
    public Optional<Category> getCategoryById(int id){
        return categoryRepository.findById(id);
    }


    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }


}
