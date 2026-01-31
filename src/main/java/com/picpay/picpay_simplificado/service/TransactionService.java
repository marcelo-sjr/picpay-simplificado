package com.picpay.picpay_simplificado.service;

import com.picpay.picpay_simplificado.authorization.AuthorizationService;
import com.picpay.picpay_simplificado.dto.TransactionDto;
import com.picpay.picpay_simplificado.dto.TransactionRequest;
import com.picpay.picpay_simplificado.exception.InsufficientBalanceException;
import com.picpay.picpay_simplificado.exception.InvalidPayerException;
import com.picpay.picpay_simplificado.exception.InvalidTransactionValueException;
import com.picpay.picpay_simplificado.exception.UserNotFoundException;
import com.picpay.picpay_simplificado.mapper.TransactionMapper;
import com.picpay.picpay_simplificado.model.Transaction;
import com.picpay.picpay_simplificado.model.User;
import com.picpay.picpay_simplificado.model.UserType;
import com.picpay.picpay_simplificado.notification.NotificationService;
import com.picpay.picpay_simplificado.repository.TransactionRepository;
import com.picpay.picpay_simplificado.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository repository;
    private final UserRepository userRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final TransactionMapper mapper;

    @Transactional
    public TransactionDto newTransaction(TransactionRequest request) {

        var payer = userRepository.findById(request.payer()).orElseThrow(UserNotFoundException::new);
        var payee = userRepository.findById(request.payee()).orElseThrow(UserNotFoundException::new);

        validate(request, payer, payee);

        authorizationService.authorize(request);

        payer.debit(request.value());

        payee.credit(request.value());

        Transaction newTransaction = repository.save(mapper.toTransaction(request.value(), payer, payee));

        notificationService.notify(request);

        return mapper.toTransactionDto(newTransaction);
    }

    public List<TransactionDto> findAll() {
        return repository.findAll().stream().map(mapper::toTransactionDto).toList();
    }


    private void validate(TransactionRequest request, User payer, User payee) {
        if (request.value().compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidTransactionValueException("Transaction value must be higher than 0.");
        }
        if (payer.equals(payee)){
            throw new InvalidPayerException("Payer must not be the same as payee.");
        }
        if (payer.getUserType().equals(UserType.LOJISTA)){
            throw new InvalidPayerException("Payer can't the of type %s.".formatted(payer.getUserType()));
        }
        if (payer.getBalance().compareTo(request.value()) < 0){
            throw new InsufficientBalanceException("Insufficient Balance for this transaction.");
        }
    }
}
