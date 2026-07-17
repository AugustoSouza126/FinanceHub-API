package com.augustosouza.financehub.user.controller;

import com.augustosouza.financehub.user.dto.UserResponse;
import com.augustosouza.financehub.user.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users/me")
    public UserResponse me(@AuthenticationPrincipal User user) {

        return UserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();

    }

}