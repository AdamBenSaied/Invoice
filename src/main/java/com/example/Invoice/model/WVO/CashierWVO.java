package com.example.Invoice.model.WVO;

import java.io.Serializable;

public class CashierWVO implements Serializable {

private UserWVO userWVO;

private CompanyWVO companyWVO;

    public CashierWVO() {
    }

    public CashierWVO(UserWVO userWVO, CompanyWVO companyWVO) {
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
