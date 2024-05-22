package com.example.Invoice.service;

import com.example.Invoice.model.VO.CompanyVO;

public interface CompanyService {

    CompanyVO saveCompany(CompanyVO companyVO);

    CompanyVO saveCompanyIfDoesNotExist(CompanyVO companyVO);

}

