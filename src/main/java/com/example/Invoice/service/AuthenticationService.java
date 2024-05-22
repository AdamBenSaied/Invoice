package com.example.Invoice.service;

import com.example.Invoice.model.VO.UserVO;
import com.example.Invoice.model.WVO.AdminWVO;
import com.example.Invoice.model.WVO.AuthenticationResponse;
import com.example.Invoice.model.WVO.CashierWVO;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    AuthenticationResponse registerCashier(CashierWVO cashierWVO);

    AuthenticationResponse registerAdmin(AdminWVO adminWVO);

    void saveUserToken(UserVO userVO, String jwtToken);

    ResponseEntity<AuthenticationResponse> loginCashier(CashierWVO cashierWVO);

    ResponseEntity<AuthenticationResponse> loginAdmin(AdminWVO adminWVO);

    void revokeAllUserTokens(UserVO user);

    void refreshTokenCashier(HttpServletRequest request, HttpServletResponse response)
            throws IOException, java.io.IOException;
    void refreshTokenAdmin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, java.io.IOException;


}
