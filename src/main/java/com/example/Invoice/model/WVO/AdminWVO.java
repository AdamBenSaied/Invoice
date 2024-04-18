package com.example.Invoice.model.WVO;

import com.example.Invoice.model.VO.CompanyVO;

import java.io.Serializable;

public class AdminWVO implements Serializable {

    private UserWVO userWVO;
    private CompanyWVO companyWVO;


    public AdminWVO() {
    }

    public AdminWVO(UserWVO userWVO, CompanyWVO companyWVO) {
        this.userWVO = userWVO;
        this.companyWVO = companyWVO;
    }

    public UserWVO getUserWVO() {
        return userWVO;
    }

    public void setUserWVO(UserWVO userWVO) {
        this.userWVO = userWVO;
    }

    public CompanyWVO getCompanyWVO() {
        return companyWVO;
    }

    public void setCompanyWVO(CompanyWVO companyWVO) {
        this.companyWVO = companyWVO;
    }
}
