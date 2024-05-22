package com.example.Invoice.model.WVO;



import java.io.Serializable;

public class ClientWVO implements Serializable {

    private UserWVO userWVO;

    public ClientWVO() {
    }

    public ClientWVO(UserWVO userWVO) {
        this.userWVO = userWVO;
    }

    public UserWVO getUserWVO() {
        return userWVO;
    }

    public void setUserWVO(UserWVO userWVO) {
        this.userWVO = userWVO;
    }
}
