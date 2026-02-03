package com.picpay.picpay_simplificado.controller;

import com.picpay.picpay_simplificado.dto.TransactionDto;
import com.picpay.picpay_simplificado.dto.TransactionRequest;
import com.picpay.picpay_simplificado.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionRequest transactionRequest){
        return ResponseEntity.ok(transactionService.newTransaction(transactionRequest));
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> listAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }
}
