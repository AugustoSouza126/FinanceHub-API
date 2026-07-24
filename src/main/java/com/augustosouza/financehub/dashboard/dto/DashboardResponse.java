package com.augustosouza.financehub.dashboard.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record DashboardResponse(

        BigDecimal totalIncome,
        BigDecimal totalExpense,
        BigDecimal balance

) {
}