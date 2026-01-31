package com.picpay.picpay_simplificado.dto;

import com.picpay.picpay_simplificado.model.UserType;

public record UserDto(Long id, String name, UserType userType) {
}
