package com.augustosouza.financehub.auth.controller;


import com.augustosouza.financehub.auth.dto.LoginRequest;
import com.augustosouza.financehub.auth.dto.LoginResponse;
import com.augustosouza.financehub.auth.dto.RegisterRequest;
import com.augustosouza.financehub.auth.dto.RegisterResponse;
import com.augustosouza.financehub.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody @Valid RegisterRequest request){

        return service.register(request);

    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {

        return service.login(request);

    }
}