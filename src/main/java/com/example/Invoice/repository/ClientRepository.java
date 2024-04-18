package com.example.Invoice.repository;

import com.example.Invoice.model.VO.ClientVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientVO, Long> {
}
