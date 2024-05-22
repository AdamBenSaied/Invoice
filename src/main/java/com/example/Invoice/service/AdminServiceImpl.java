package com.example.Invoice.service;

import com.example.Invoice.model.VO.AdminVO;
import com.example.Invoice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminVO saveAdmin(AdminVO adminVO) {
        return adminRepository.saveAndFlush(adminVO);
    }

    @Override
    public Optional<Object> findAdminByMail(String mail) {
        return adminRepository.findByMail(mail);
    }
}
