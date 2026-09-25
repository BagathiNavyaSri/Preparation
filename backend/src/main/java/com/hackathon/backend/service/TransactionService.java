package com.hackathon.backend.service;

import com.hackathon.backend.dto.TransactionRequest;
import com.hackathon.backend.dto.TransactionResponse;
import com.hackathon.backend.entity.Transaction;
import com.hackathon.backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionResponse analyzeTransaction(
            TransactionRequest request) {

        String riskLevel;
        String message;

        if (request.getAmount() > 20000) {
            riskLevel = "HIGH";
            message = "Transaction requires review";
        } else {
            riskLevel = "LOW";
            message = "Transaction appears normal";
        }

        Transaction transaction = new Transaction();

        transaction.setTransactionId(request.getTransactionId());
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setRiskLevel(riskLevel);

        transactionRepository.save(transaction);

        return new TransactionResponse(
                request.getTransactionId(),
                riskLevel,
                message
        );
    }
}