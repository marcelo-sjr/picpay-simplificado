package com.picpay.picpay_simplificado.dto;

import com.picpay.picpay_simplificado.model.UserType;

import java.math.BigDecimal;

public record UserRequest(String name, String nationalId, String email, BigDecimal balance, UserType userType) {
}
