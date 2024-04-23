package com.example.Invoice.controller;

import com.example.Invoice.model.WVO.UserWVO;
import com.example.Invoice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Invoice.constants.ENDPOINTS.USER_DETAILS;
import static com.example.Invoice.constants.ENDPOINTS.USER_ENDPOINT;
import static com.example.Invoice.constants.PARAMS.USER_ID;

@RestController
@RequestMapping(path = USER_ENDPOINT)
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


}
