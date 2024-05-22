package com.example.Invoice.model.VO;


import jakarta.persistence.*;


@Entity
@Table(name = "companies")
public class CompanyVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "EMAIL")
    private String mail;

    @Column(name = "SIRET")
    private String siret;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "LOGO")
    private String logo;

    public CompanyVO() {
    }

    public CompanyVO(String name, String address, String country, String telephone,
                     String mail, String siret, String website, String logo) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.telephone = telephone;
        this.mail = mail;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
