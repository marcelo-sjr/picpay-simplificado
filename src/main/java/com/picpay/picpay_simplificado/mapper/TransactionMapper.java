package com.picpay.picpay_simplificado.mapper;

import com.picpay.picpay_simplificado.dto.TransactionDto;
import com.picpay.picpay_simplificado.model.Transaction;
import com.picpay.picpay_simplificado.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    public TransactionDto toTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getPublic_id(),
                LocalDateTime.ofInstant(transaction.getTimeStamp(), ZoneId.of("America/Sao_Paulo")),
                transaction.getAmmount(),
                transaction.getPayer().getId(),
                transaction.getPayee().getId());
    }

    public Transaction toTransaction(BigDecimal value, User payer, User payee, Instant timeStamp) {
        Transaction transaction = new Transaction();
        transaction.setAmmount(value);
        transaction.setTimeStamp(timeStamp);
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        return transaction;
    }
}
