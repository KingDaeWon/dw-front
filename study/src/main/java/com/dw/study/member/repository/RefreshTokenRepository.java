package com.dw.study.member.repository;

import com.dw.study.member.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    // Member ID 값으로 토큰을 가져오기 위해 findByKey를 추가
    Optional<RefreshToken> findByKey(String key);
}