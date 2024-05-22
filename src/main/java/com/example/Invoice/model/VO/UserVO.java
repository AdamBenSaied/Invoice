package com.example.Invoice.model.VO;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column (name = "ADDRESS")
    private String address;

    @Column (name = "TELEPHONE")
    private String telephone;

    @Column(name ="COUNTRY")
        private String country;

    public UserVO() {

    }
    public UserVO(String name, String surname, String adress, String telephone, String country) {
        this.name = name;
        this.surname = surname;
        this.address = adress;
        this.telephone = telephone;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
