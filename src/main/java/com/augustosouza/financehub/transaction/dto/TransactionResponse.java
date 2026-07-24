package com.augustosouza.financehub.transaction.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record TransactionResponse(

        Long id,

        String description,

        BigDecimal amount,

        LocalDate date,

        String category

) {
}