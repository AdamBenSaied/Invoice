package com.example.Invoice.controller;

import com.example.Invoice.service.CompanyService;
import com.example.Invoice.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Invoice.constants.ENDPOINTS.COMPANY_ENDPOINT;

@RestController
@RequestMapping(path = COMPANY_ENDPOINT)
public class CompanyController {

    private final CompanyServiceImpl companyServiceImpl;

    @Autowired
    public CompanyController(CompanyServiceImpl companyServiceImpl) {
        this.companyServiceImpl = companyServiceImpl;
    }
}
