package com.example.Invoice.service;

import com.example.Invoice.model.VO.CompanyVO;
import com.example.Invoice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public CompanyVO saveCompany(CompanyVO companyVO) {
        return companyRepository.saveAndFlush(companyVO);
    }


    public CompanyVO saveCompanyIfDoesNotExist(CompanyVO companyVO) {
        Optional<CompanyVO> companyVOOptional = companyRepository.findBySiret(companyVO.getSiret());
        if (companyVOOptional.isPresent()) {
            return companyVOOptional.get();
        } else {
            return saveCompany(companyVO);
    }}


}
