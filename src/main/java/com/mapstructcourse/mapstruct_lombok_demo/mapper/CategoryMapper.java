package com.mapstructcourse.mapstruct_lombok_demo.mapper;

import com.mapstructcourse.mapstruct_lombok_demo.dto.GetCategory;
import com.mapstructcourse.mapstruct_lombok_demo.entity.Category;
import com.mapstructcourse.mapstruct_lombok_demo.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {
    @Autowired
    private CategoryRepository categoryRepository;

    @Mappings({
            @Mapping(source = "id", target = "categoryId"),
            @Mapping(source = "name", target = "categoryName"),
    })
    abstract GetCategory toGetCategory(Category category);
    abstract List<GetCategory> toGetCategoryList(List<Category> categories);

    Category toCategory(GetCategory getCategory){
        if (getCategory == null) return null;
        Category category = categoryRepository.findById(getCategory.getCategoryId()).orElse(null);

        if (category == null) return null;

        category.setId(getCategory.getCategoryId());
        category.setName(getCategory.getCategoryName());

        return category;
    }
    abstract List<Category> toCategoryList(List<GetCategory> getCategories);
}