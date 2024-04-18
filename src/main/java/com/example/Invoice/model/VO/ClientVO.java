package com.example.Invoice.model.VO;


import jakarta.persistence.*;

import java.security.PrivateKey;

@Entity
@Table(name = "clients")
public class ClientVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USER",referencedColumnName = "ID")
    private UserVO userVO;

    public ClientVO() {
    }

    public ClientVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }



}
