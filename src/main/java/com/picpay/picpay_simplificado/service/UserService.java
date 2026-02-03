package com.picpay.picpay_simplificado.service;

import com.picpay.picpay_simplificado.dto.UserDto;
import com.picpay.picpay_simplificado.dto.UserRequest;
import com.picpay.picpay_simplificado.exception.UserNotFoundException;
import com.picpay.picpay_simplificado.mapper.UserMapper;
import com.picpay.picpay_simplificado.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toUserDto)
                .toList();
    }

    public UserDto findById(Long id) {
        return repository.findById(id).map(mapper::toUserDto).orElseThrow(()-> new UserNotFoundException("User not found!"));
    }

    public UserDto save(UserRequest request) {
        return mapper.toUserDto(repository.save(mapper.toUser(request)));
    }
}
