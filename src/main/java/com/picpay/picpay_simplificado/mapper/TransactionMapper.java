package com.picpay.picpay_simplificado.mapper;

import com.picpay.picpay_simplificado.dto.PartySummary;
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
                LocalDateTime.ofInstant(transaction.getCreatedAt(), ZoneId.of("America/Sao_Paulo")),
                transaction.getAmmount(),
                new PartySummary(transaction.getPayer().getPublic_id(),transaction.getPayer().getName(),transaction.getPayer().getUserType()),
                new PartySummary(transaction.getPayee().getPublic_id(),transaction.getPayee().getName(),transaction.getPayee().getUserType()));
    }

    public Transaction toTransaction(BigDecimal value, User payer, User payee, Instant timestamp) {
        Transaction transaction = new Transaction();
        transaction.setAmmount(value);
        transaction.setCreatedAt(timestamp);
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        return transaction;
    }
}
