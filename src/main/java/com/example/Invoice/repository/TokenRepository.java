package com.example.Invoice.repository;

import com.example.Invoice.model.VO.TokenVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenVO,Long> {

    List<TokenVO> findByUser_IdAndRevokedAndExpired(Long id, boolean revoked, boolean expired);
    Optional<TokenVO> findByToken(String Token);
}
