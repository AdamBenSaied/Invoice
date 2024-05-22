package com.example.Invoice.repository;

import com.example.Invoice.model.VO.AdminVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminVO, Long> {


    boolean existsByMail(String username);

    Optional<Object> findByMail(String username);
}
