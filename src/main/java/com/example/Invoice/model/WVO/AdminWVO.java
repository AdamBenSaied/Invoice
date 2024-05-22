package com.example.Invoice.model.WVO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class AdminWVO implements Serializable {

    private String mail;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String password;

    private UserWVO userWVO;
    private CompanyWVO companyWVO;


    public AdminWVO() {
    }

    public AdminWVO(UserWVO userWVO, CompanyWVO companyWVO) {
        this.userWVO = userWVO;
        this.companyWVO = companyWVO;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
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
