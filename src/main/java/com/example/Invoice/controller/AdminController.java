package com.example.Invoice.controller;


import com.example.Invoice.service.AdminService;
import com.example.Invoice.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Invoice.constants.ENDPOINTS.ADMIN_ENDPOINT;

@RestController
@RequestMapping(path = ADMIN_ENDPOINT)
public class AdminController {

    private final AdminServiceImpl adminServiceImpl;

    @Autowired
    public AdminController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

}
