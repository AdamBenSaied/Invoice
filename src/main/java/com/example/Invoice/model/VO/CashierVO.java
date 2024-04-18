package com.example.Invoice.model.VO;


import jakarta.persistence.*;

@Entity
@Table(name = "cashiers")
public class CashierVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public CashierVO(UserVO userVO, CompanyVO companyVO) {
        this.userVO = userVO;
        this.companyVO = companyVO;
    }

    public CashierVO(CompanyVO companyVO) {
        this.companyVO = companyVO;
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


}
