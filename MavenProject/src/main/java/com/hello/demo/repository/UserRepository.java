package com.hello.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.demo.domain.User;

// User 테이블의 Id값은 Long형
public interface UserRepository extends JpaRepository<User, Long> {

}
