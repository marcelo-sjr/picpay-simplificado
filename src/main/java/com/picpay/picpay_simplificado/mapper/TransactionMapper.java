package com.picpay.picpay_simplificado.mapper;

import com.picpay.picpay_simplificado.dto.PartySummary;
import com.picpay.picpay_simplificado.dto.TransactionDto;
import com.picpay.picpay_simplificado.model.Transaction;
import com.picpay.picpay_simplificado.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
@RequiredArgsConstructor
public class TransactionMapper {

    public TransactionDto toTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getPublicId(),
                OffsetDateTime.ofInstant(transaction.getCreatedAt(), ZoneOffset.UTC),
                transaction.getAmmount(),
                new PartySummary(transaction.getPayer().getPublicId(),transaction.getPayer().getName(),transaction.getPayer().getUserType()),
                new PartySummary(transaction.getPayee().getPublicId(),transaction.getPayee().getName(),transaction.getPayee().getUserType()));
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
