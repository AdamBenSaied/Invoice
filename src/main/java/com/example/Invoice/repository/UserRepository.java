package com.example.Invoice.repository;

import com.example.Invoice.model.VO.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserVO, Long> {
}
