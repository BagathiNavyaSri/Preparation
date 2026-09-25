package com.hackathon.backend;

import com.hackathon.backend.dto.TransactionRequest;
import com.hackathon.backend.dto.TransactionResponse;
import com.hackathon.backend.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class HelloController {

    private final TransactionService transactionService;

    public HelloController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from BNP Hackathon Backend!";
    }

    @PostMapping("/api/transactions")
    public TransactionResponse analyzeTransaction(
            @RequestBody TransactionRequest request) {

        return transactionService.analyzeTransaction(request);
    }
}