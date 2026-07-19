package com.augustosouza.financehub.category.controller;

import com.augustosouza.financehub.category.dto.CategoryRequest;
import com.augustosouza.financehub.category.dto.CategoryResponse;
import com.augustosouza.financehub.category.service.CategoryService;
import com.augustosouza.financehub.user.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public CategoryResponse create(
            @RequestBody @Valid CategoryRequest request,
            @AuthenticationPrincipal User user
    ) {

        return service.create(request, user);

    }

    @GetMapping
    public List<CategoryResponse> findAll(
            @AuthenticationPrincipal User user
    ) {

        return service.findAll(user);

    }

    @GetMapping("/{id}")
    public CategoryResponse findById(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {

        return service.findById(id, user);

    }

    @PutMapping("/{id}")
    public CategoryResponse update(
            @PathVariable Long id,
            @RequestBody @Valid CategoryRequest request,
            @AuthenticationPrincipal User user
    ) {

        return service.update(id, request, user);

    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {

        service.delete(id, user);

    }

}