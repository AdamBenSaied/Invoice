package com.example.Invoice.model.VO;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "cashiers")
public class CashierVO implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "MAIL")
    private String mail;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne
    @JoinColumn(name = "ID_USER",referencedColumnName = "ID")
    private UserVO userVO;

    @ManyToOne
    @JoinColumn(name = "ID_COMPANY", referencedColumnName = "ID")
    private CompanyVO companyVO;

    public CashierVO() {
    }

    public CashierVO(String mail, String password, UserVO userVO, CompanyVO companyVO) {
        this.mail = mail;
        this.password = password;
        this.userVO = userVO;
        this.companyVO = companyVO;
    }

    public CashierVO(UserVO userVO, CompanyVO companyVO) {
        this.userVO = userVO;
        this.companyVO = companyVO;
    }

    public CashierVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public CompanyVO getCompanyVO() {
        return companyVO;
    }

    public void setCompanyVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
