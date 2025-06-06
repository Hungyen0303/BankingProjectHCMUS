package com.example.banking.backend.repository;

import com.example.banking.backend.model.Account;
import com.example.banking.backend.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    @Query("SELECT t FROM Transaction t WHERE t.fromBank.id = :bankId AND t.createdAt BETWEEN :startDate AND :endDate")
    List<Transaction> findByBankIdAndDateRange(UUID bankId, LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT t FROM Transaction t WHERE t.fromBank.id = :bankId AND t.createdAt BETWEEN :startDate AND :endDate")
    List<Transaction> findByBankIdAndDateRange(UUID bankId, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    List<Transaction> findByCreatedAtBetween(Instant startDate, Instant endDate);
    Page<Transaction> findByFromAccountId(UUID accountId, Pageable pageable);}

