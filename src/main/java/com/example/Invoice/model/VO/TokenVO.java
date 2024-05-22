package com.example.Invoice.model.VO;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")

public class TokenVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "REVOKED")
    private boolean revoked;

    @Column(name = "EXPIRED")
    private boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    private UserVO user;

    public TokenVO(String token, boolean revoked, boolean expired, UserVO user) {
        this.token = token;
        this.revoked = revoked;
        this.expired = expired;
        this.user = user;
    }

    public TokenVO(UserVO user, String token, boolean expired, boolean revoked) {
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public TokenVO() {
    }

    public TokenVO(Long id, String token, boolean revoked, boolean expired, UserVO user) {
        this.id = id;
        this.token = token;
        this.revoked = revoked;
        this.expired = expired;
        this.user = user;
    }


}