package com.example.Invoice.model.WVO;

import java.io.Serializable;

public class CompanyWVO implements Serializable {


    private String name;
    private String  address;

    private String country;

    private String telephone;

    private String email;

    private String siret;

    private String website;

    private String logo;

    public CompanyWVO() {
    }

    public CompanyWVO(String name, String address, String country,
                      String telephone, String email, String siret, String website, String logo) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.telephone = telephone;
        this.email = email;
        this.siret = siret;
        this.website = website;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
