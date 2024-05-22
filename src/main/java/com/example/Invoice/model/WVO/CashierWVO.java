package com.example.Invoice.model.WVO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class CashierWVO implements Serializable {

    private String mail;

    private UserWVO userWVO;

    private CompanyWVO companyWVO;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;

    public CashierWVO() {
    }

    public CashierWVO(String mail, UserWVO userWVO, CompanyWVO companyWVO) {
        this.mail = mail;
        this.userWVO = userWVO;
        this.companyWVO = companyWVO;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
