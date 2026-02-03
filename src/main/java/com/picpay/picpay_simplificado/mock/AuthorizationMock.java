package com.picpay.picpay_simplificado.mock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("mock/authorization")
public class AuthorizationMock {

    private final Random random = new Random();

    record AuthorizationResponse(boolean authorization) {
    }

    @GetMapping
    public ResponseEntity<AuthorizationResponse> authorization() {
        return ResponseEntity.ok(new AuthorizationResponse(random.nextBoolean()));
    }
}
