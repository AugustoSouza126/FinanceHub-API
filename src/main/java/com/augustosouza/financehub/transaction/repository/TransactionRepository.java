package com.augustosouza.financehub.transaction.repository;

import com.augustosouza.financehub.transaction.entity.Transaction;
import com.augustosouza.financehub.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByUser(User user, Pageable pageable);

    Optional<Transaction> findByIdAndUser(Long id, User user);

    @Query("""
        SELECT COALESCE(SUM(t.amount),0)
        FROM Transaction t
        WHERE t.user = :user
        AND t.category.type = 'INCOME'
        """)
    BigDecimal getTotalIncome(User user);

    @Query("""
        SELECT COALESCE(SUM(t.amount),0)
        FROM Transaction t
        WHERE t.user = :user
        AND t.category.type = 'EXPENSE'
        """)
    BigDecimal getTotalExpense(User user);

}