package com.augustosouza.financehub.auth.service;


import com.augustosouza.financehub.auth.dto.LoginRequest;
import com.augustosouza.financehub.auth.dto.LoginResponse;
import com.augustosouza.financehub.auth.dto.RegisterRequest;
import com.augustosouza.financehub.auth.dto.RegisterResponse;
import com.augustosouza.financehub.common.exception.EmailAlreadyExistsException;
import com.augustosouza.financehub.user.entity.User;
import com.augustosouza.financehub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public RegisterResponse register(RegisterRequest request){

        if (repository.existsByEmail(request.email())){
            throw new EmailAlreadyExistsException();
        }

        User user = User.builder()
                .fullName(request.fullName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        repository.save(user);

        return RegisterResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .build();

    }

    public LoginResponse login(LoginRequest request) {

        User user = repository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Invalid email or password."));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password.");
        }

        String token = jwtService.generateToken(user.getEmail());

        return LoginResponse.builder()
                .token(token)
                .build();
    }



}
