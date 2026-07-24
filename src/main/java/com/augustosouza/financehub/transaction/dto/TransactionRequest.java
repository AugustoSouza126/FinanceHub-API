package com.augustosouza.financehub.transaction.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequest(

        @NotBlank
        String description,

        @NotNull
        BigDecimal amount,

        @NotNull
        LocalDate date,

        @NotNull
        Long categoryId

) {
}