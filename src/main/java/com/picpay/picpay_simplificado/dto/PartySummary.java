package com.picpay.picpay_simplificado.dto;

import com.picpay.picpay_simplificado.model.UserType;

import java.util.UUID;

public record PartySummary(UUID id, String name, UserType userType) {
}
