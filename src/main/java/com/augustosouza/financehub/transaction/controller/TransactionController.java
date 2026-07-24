package com.augustosouza.financehub.transaction.controller;

import com.augustosouza.financehub.transaction.dto.TransactionRequest;
import com.augustosouza.financehub.transaction.dto.TransactionResponse;
import com.augustosouza.financehub.transaction.service.TransactionService;
import com.augustosouza.financehub.user.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    public TransactionResponse create(
            @RequestBody @Valid TransactionRequest request,
            @AuthenticationPrincipal User user
    ) {

        return service.create(request, user);

    }



    @GetMapping
    public Page<TransactionResponse> findAll(
            @AuthenticationPrincipal User user,
            Pageable pageable
    ) {
        return service.findAll(user, pageable);
    }

    @GetMapping("/{id}")
    public TransactionResponse findById(
            @PathVariable Long id,
            @AuthenticationPrincipal User user
    ) {
        return service.findById(id, user);
    }

    @PutMapping("/{id}")
    public TransactionResponse update(
            @PathVariable Long id,
            @RequestBody @Valid TransactionRequest request,
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