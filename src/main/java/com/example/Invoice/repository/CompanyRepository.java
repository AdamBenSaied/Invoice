package com.example.Invoice.repository;

import com.example.Invoice.model.VO.CompanyVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyVO, Long> {
}
