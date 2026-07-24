package com.augustosouza.financehub.dashboard.service;

import com.augustosouza.financehub.dashboard.dto.DashboardResponse;
import com.augustosouza.financehub.transaction.repository.TransactionRepository;
import com.augustosouza.financehub.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final TransactionRepository repository;

    public DashboardResponse getDashboard(User user){

        BigDecimal income = repository.getTotalIncome(user);
        BigDecimal expense = repository.getTotalExpense(user);

        return DashboardResponse.builder()
                .totalIncome(income)
                .totalExpense(expense)
                .balance(income.subtract(expense))
                .build();

    }

}