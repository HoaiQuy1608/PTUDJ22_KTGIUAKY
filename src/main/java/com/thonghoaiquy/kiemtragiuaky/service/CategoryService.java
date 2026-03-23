package com.thonghoaiquy.kiemtragiuaky.service;

import com.thonghoaiquy.kiemtragiuaky.model.Category;
import com.thonghoaiquy.kiemtragiuaky.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}