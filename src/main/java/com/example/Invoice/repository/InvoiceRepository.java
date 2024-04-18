package com.example.Invoice.repository;

import com.example.Invoice.model.VO.InvoiceVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceVO, Long> {
}
