package com.example.Invoice.service;

import com.example.Invoice.model.VO.AdminVO;

import java.util.Optional;

public interface AdminService {

    AdminVO saveAdmin(AdminVO adminVO);
    Optional<Object> findAdminByMail(String mail);
}
