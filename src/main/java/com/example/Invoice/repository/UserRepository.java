package com.example.Invoice.repository;

import com.example.Invoice.model.VO.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserVO, Long> {

    Optional<UserVO> findByNameAndSurname(String name, String surname);
}
