package com.augustosouza.financehub.category.service;

import com.augustosouza.financehub.category.dto.CategoryRequest;
import com.augustosouza.financehub.category.dto.CategoryResponse;
import com.augustosouza.financehub.category.entity.Category;
import com.augustosouza.financehub.category.repository.CategoryRepository;
import com.augustosouza.financehub.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public List<CategoryResponse> findAll(User user) {

        List<Category> categories = repository.findByUser(user);

        return categories.stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .type(category.getType())
                        .build())
                .toList();

    }

    public CategoryResponse findById(Long id, User user) {

        Category category = repository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .type(category.getType())
                .build();

    }

    public CategoryResponse update(Long id, CategoryRequest request, User user) {

        Category category = repository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        category.setName(request.name());
        category.setType(request.type());

        repository.save(category);

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .type(category.getType())
                .build();
    }

    public void delete(Long id, User user) {

        Category category = repository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        repository.delete(category);

    }

}