package com.augustosouza.financehub.auth.dto;

import lombok.Builder;

@Builder
public record RegisterResponse (

        Long id,
        String fullName,
        String email

){
}
