package com.augustosouza.financehub.category.service;

import com.augustosouza.financehub.category.dto.CategoryRequest;
import com.augustosouza.financehub.category.dto.CategoryResponse;
import com.augustosouza.financehub.category.entity.Category;
import com.augustosouza.financehub.category.repository.CategoryRepository;
import com.augustosouza.financehub.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryResponse create(CategoryRequest request, User user) {

        Category category = Category.builder()
                .name(request.name())
                .type(request.type())
                .user(user)
                .build();

        Category savedCategory = repository.save(category);

        return CategoryResponse.builder()
                .id(savedCategory.getId())
                .name(savedCategory.getName())
                .type(savedCategory.getType())
                .build();
    }

}