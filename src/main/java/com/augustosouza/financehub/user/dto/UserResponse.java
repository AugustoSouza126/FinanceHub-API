package com.augustosouza.financehub.user.dto;

import lombok.Builder;

@Builder
public record UserResponse(

        Long id,
        String fullName,
        String email

) {
}