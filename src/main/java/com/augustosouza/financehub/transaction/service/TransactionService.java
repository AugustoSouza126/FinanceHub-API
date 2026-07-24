package com.augustosouza.financehub.transaction.service;

import com.augustosouza.financehub.category.entity.Category;
import com.augustosouza.financehub.category.repository.CategoryRepository;
import com.augustosouza.financehub.transaction.dto.TransactionRequest;
import com.augustosouza.financehub.transaction.dto.TransactionResponse;
import com.augustosouza.financehub.transaction.entity.Transaction;
import com.augustosouza.financehub.transaction.repository.TransactionRepository;
import com.augustosouza.financehub.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionResponse create(TransactionRequest request, User user) {

        Category category = categoryRepository.findByIdAndUser(request.categoryId(), user)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Transaction transaction = Transaction.builder()
                .description(request.description())
                .amount(request.amount())
                .date(request.date())
                .category(category)
                .user(user)
                .build();

        Transaction saved = transactionRepository.save(transaction);

        return TransactionResponse.builder()
                .id(saved.getId())
                .description(saved.getDescription())
                .amount(saved.getAmount())
                .date(saved.getDate())
                .category(saved.getCategory().getName())
                .build();
    }

    public List<TransactionResponse> findAll(User user) {

        return transactionRepository.findByUser(user)
                .stream()
                .map(transaction -> TransactionResponse.builder()
                        .id(transaction.getId())
                        .description(transaction.getDescription())
                        .amount(transaction.getAmount())
                        .date(transaction.getDate())
                        .category(transaction.getCategory().getName())
                        .build())
                .toList();

    }

    public TransactionResponse findById(Long id, User user) {

        Transaction transaction = transactionRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        return TransactionResponse.builder()
                .id(transaction.getId())
                .description(transaction.getDescription())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .category(transaction.getCategory().getName())
                .build();

    }

    public TransactionResponse update(Long id, TransactionRequest request, User user) {

        Transaction transaction = transactionRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        Category category = categoryRepository.findByIdAndUser(request.categoryId(), user)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        transaction.setDescription(request.description());
        transaction.setAmount(request.amount());
        transaction.setDate(request.date());
        transaction.setCategory(category);

        Transaction updated = transactionRepository.save(transaction);

        return TransactionResponse.builder()
                .id(updated.getId())
                .description(updated.getDescription())
                .amount(updated.getAmount())
                .date(updated.getDate())
                .category(updated.getCategory().getName())
                .build();

    }

    public void delete(Long id, User user) {

        Transaction transaction = transactionRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        transactionRepository.delete(transaction);

    }

}