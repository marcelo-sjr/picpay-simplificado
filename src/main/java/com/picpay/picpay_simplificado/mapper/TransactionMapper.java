package com.picpay.picpay_simplificado.mapper;

import com.picpay.picpay_simplificado.dto.TransactionDto;
import com.picpay.picpay_simplificado.dto.TransactionRequest;
import com.picpay.picpay_simplificado.model.Transaction;
import com.picpay.picpay_simplificado.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    private final UserMapper userMapper;

    public TransactionDto toTransactionDto(Transaction transaction) {
        return new TransactionDto(transaction.getAmmount(), userMapper.toUserDto(transaction.getPayer()), userMapper.toUserDto(transaction.getPayee()));
    }

    public Transaction toTransaction(BigDecimal value, User payer, User payee) {
        Transaction transaction = new Transaction();
        transaction.setAmmount(value);
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        transaction.setCreatedAt(LocalDateTime.now());
        return transaction;
    }
}
