package com.augustosouza.financehub.category.dto;

import com.augustosouza.financehub.category.entity.CategoryType;
import lombok.Builder;

@Builder
public record CategoryResponse(

        Long id,
        String name,
        CategoryType type

) {
}