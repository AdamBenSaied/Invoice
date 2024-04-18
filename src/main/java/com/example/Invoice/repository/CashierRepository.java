package com.example.Invoice.repository;

import com.example.Invoice.model.VO.CashierVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends JpaRepository<CashierVO, Long> {

}
