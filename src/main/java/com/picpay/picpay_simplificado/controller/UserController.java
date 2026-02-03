package com.picpay.picpay_simplificado.controller;

import com.picpay.picpay_simplificado.dto.UserDto;
import com.picpay.picpay_simplificado.dto.UserRequest;
import com.picpay.picpay_simplificado.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("list")
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("create")
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(service.save(request));
    }
}
