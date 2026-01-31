package com.picpay.picpay_simplificado.mapper;

import com.picpay.picpay_simplificado.dto.UserDto;
import com.picpay.picpay_simplificado.dto.UserRequest;
import com.picpay.picpay_simplificado.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUserDto(User user){
        return new UserDto(user.getId(),user.getName(),user.getUserType());
    }

    public User toUser(UserRequest request){
        var user = new User();
        user.setName(request.name());
        user.setCpf_cnpj(request.nationalId());
        user.setEmail(request.email());
        user.setBalance(request.balance());
        user.setUserType(request.userType());

        return user;
    }
}
