package com.example.Invoice.service;

import com.example.Invoice.model.VO.UserVO;

public interface UserService {

    UserVO saveUser(UserVO userVO);

    UserVO saveUserIfDoesNotExist(UserVO userVO);
}
