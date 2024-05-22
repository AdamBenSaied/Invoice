package com.example.Invoice.controller;


import com.example.Invoice.model.WVO.AdminWVO;
import com.example.Invoice.model.WVO.AuthenticationResponse;
import com.example.Invoice.model.WVO.CashierWVO;
import com.example.Invoice.service.AuthenticationServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.example.Invoice.constants.ENDPOINTS.*;

@RestController
@RequestMapping(AUTH_ENDPOINT)
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = CASHIER_AUTH_REGISTER)
    public ResponseEntity<AuthenticationResponse> registerCashier(@RequestBody CashierWVO cashierWVO) {
        return ResponseEntity.ok(authenticationService.registerCashier(cashierWVO));
    }

    @PostMapping(path = ADMIN_AUTH_REGISTER)
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody AdminWVO adminWVO) {
        return ResponseEntity.ok(authenticationService.registerAdmin(adminWVO));
    }

    @PostMapping(path = CASHIER_AUTH_LOGIN)
    public ResponseEntity<AuthenticationResponse> loginCashier(@RequestBody CashierWVO cashierWVO)
    {
        return authenticationService.loginCashier(cashierWVO);
    }
    @PostMapping(path = ADMIN_AUTH_LOGIN)
    public ResponseEntity<AuthenticationResponse> loginAdmin(@RequestBody AdminWVO adminWVO)
    {
        return authenticationService.loginAdmin(adminWVO);
    }

    @PostMapping(path = CASHIER_REFRESH_TOKEN)
    public void cashierRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
         authenticationService.refreshTokenCashier(request,response);
    }
    @PostMapping(path = ADMIN_REFRESH_TOKEN)
    public void adminRefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
         authenticationService.refreshTokenAdmin(request,response);
    }



}
