package com.picpay.picpay_simplificado.controller;

import com.picpay.picpay_simplificado.dto.TransactionDto;
import com.picpay.picpay_simplificado.dto.TransactionRequest;
import com.picpay.picpay_simplificado.model.Transaction;
import com.picpay.picpay_simplificado.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/new")
    public ResponseEntity<TransactionDto> newTransaction(@RequestBody TransactionRequest transactionRequest){
        return ResponseEntity.ok(transactionService.newTransaction(transactionRequest));
    }

    @GetMapping("list")
    public ResponseEntity<List<TransactionDto>> listAll(){
        return ResponseEntity.ok(transactionService.findAll());
    }
}
