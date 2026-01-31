package com.picpay.picpay_simplificado.dto;

import java.math.BigDecimal;

public record TransactionDto(BigDecimal value, UserDto payer, UserDto payee) {
}
