package com.mapstructcourse.mapstruct_lombok_demo.mapper;

import com.mapstructcourse.mapstruct_lombok_demo.dto.GetCategory;
import com.mapstructcourse.mapstruct_lombok_demo.entity.Category;
import com.mapstructcourse.mapstruct_lombok_demo.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {
    private final CategoryRepository categoryRepository;

    @Autowired
    protected CategoryMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    abstract GetCategory toGetCategory(Category category);
    abstract List<GetCategory> toGetCategoryList(List<Category> categories);

    Category toCategory(GetCategory getCategory){
        if (getCategory == null) return null;
        Category category = categoryRepository.findById(getCategory.getId())
    }
    List<Category> toCategoryList(List<GetCategory> getCategories);
}