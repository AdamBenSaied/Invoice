package com.example.Invoice.model.VO;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MAIL")
    private String mail;

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
    public UserVO(String mail, String name, String surname, String adress, String telephone, String country) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.address = adress;
        this.telephone = telephone;
        this.country = country;
    }



}
