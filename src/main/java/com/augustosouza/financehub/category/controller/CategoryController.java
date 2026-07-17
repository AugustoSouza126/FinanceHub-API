package com.augustosouza.financehub.category.controller;

import com.augustosouza.financehub.category.dto.CategoryRequest;
import com.augustosouza.financehub.category.dto.CategoryResponse;
import com.augustosouza.financehub.category.service.CategoryService;
import com.augustosouza.financehub.user.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

}