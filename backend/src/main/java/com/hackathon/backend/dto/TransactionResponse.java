package com.hackathon.backend.dto;

public class TransactionResponse {

    private String transactionId;
    private String riskLevel;
    private String message;

    public TransactionResponse(String transactionId, String riskLevel, String message) {
        this.transactionId = transactionId;
        this.riskLevel = riskLevel;
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public String getMessage() {
        return message;
    }
}