package com.augustosouza.financehub.category.dto;

import com.augustosouza.financehub.category.entity.CategoryType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(

        @NotBlank
        String name,

        @NotNull
        CategoryType type

) {
}