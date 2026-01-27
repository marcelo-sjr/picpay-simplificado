package com.picpay.picpay_simplificado.repository;

import com.picpay.picpay_simplificado.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
