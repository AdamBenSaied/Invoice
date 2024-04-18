package com.example.Invoice.repository;

import com.example.Invoice.model.VO.ProductVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductVO, Long> {
}
