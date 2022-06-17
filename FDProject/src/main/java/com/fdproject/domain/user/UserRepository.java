package com.fdproject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 기존 사용자 여부 확인 메소드
    Optional<User> findByEmail(String email);
}
