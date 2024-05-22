package com.example.Invoice.service;

import com.example.Invoice.model.VO.*;
import com.example.Invoice.model.VO.CashierVO;
import com.example.Invoice.model.WVO.*;
import com.example.Invoice.repository.TokenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CashierServiceImpl cashierServiceImpl;

    private final AdminServiceImpl adminServiceImpl;
    private final CompanyServiceImpl companyService;

    private final UserServiceImpl userServiceImpl;
    private final PasswordEncoder passwordEncoder;
    private final TokenServiceImpl tokenServiceImpl;
    private final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;

    private final Mapper mapper;


    @Autowired
    public AuthenticationServiceImpl(CashierServiceImpl cashierServiceImpl, AdminServiceImpl adminServiceImpl,
                                     UserServiceImpl userServiceImpl, PasswordEncoder passwordEncoder,
                                     CompanyServiceImpl companyService, TokenServiceImpl tokenServiceImpl,
                                     AuthenticationManager authenticationManager,
                                     TokenRepository tokenRepository, Mapper mapper) {
        this.cashierServiceImpl = cashierServiceImpl;
        this.adminServiceImpl = adminServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.companyService = companyService;
        this.tokenServiceImpl = tokenServiceImpl;
        this.authenticationManager = authenticationManager;
        this.tokenRepository = tokenRepository;
        this.mapper = mapper;
    }


    public AuthenticationResponse registerCashier(CashierWVO cashierWVO) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        UserVO userVO = userServiceImpl.saveUserIfDoesNotExist(mapper.map(cashierWVO.getUserWVO(), UserVO.class));

        CompanyVO companyVO = companyService.saveCompanyIfDoesNotExist(mapper.map(cashierWVO.getCompanyWVO(), CompanyVO.class));

        CashierVO cashierVO = new CashierVO(
                cashierWVO.getMail(),
                passwordEncoder.encode(cashierWVO.getPassword()),
                userVO,
                companyVO
        );

        cashierServiceImpl.saveCashier(cashierVO);

        var savedUser = userServiceImpl.saveUser(userVO);
        var jwToken = tokenServiceImpl.generateToken(cashierVO);
        var refreshToken = tokenServiceImpl.generateRefreshToken(cashierVO);
        authenticationResponse.setAccessToken(jwToken);
        authenticationResponse.setRefreshToken(refreshToken);
        saveUserToken(savedUser, jwToken);
        return authenticationResponse;
    }


    public AuthenticationResponse registerAdmin(AdminWVO adminWVO) {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();

        UserVO userVO = userServiceImpl.saveUserIfDoesNotExist(mapper.map(adminWVO.getUserWVO(), UserVO.class));
        CompanyVO companyVO = companyService.saveCompanyIfDoesNotExist(mapper.map(adminWVO.getCompanyWVO(), CompanyVO.class));

        AdminVO adminVO = new AdminVO(
                adminWVO.getMail(),
                passwordEncoder.encode(adminWVO.getPassword()),
                userVO,
                companyVO
        );
        adminServiceImpl.saveAdmin(adminVO);

        var savedUser = userServiceImpl.saveUser(userVO);
        var jwToken = tokenServiceImpl.generateToken(adminVO);
        var refreshToken = tokenServiceImpl.generateRefreshToken(adminVO);
        authenticationResponse.setAccessToken(jwToken);
        authenticationResponse.setRefreshToken(refreshToken);
        saveUserToken(savedUser, jwToken);
        return authenticationResponse;
    }

    public void saveUserToken(UserVO userVO, String jwtToken) {
        TokenVO tokenVO = new TokenVO(jwtToken, false, false, userVO);
        tokenRepository.saveAndFlush(tokenVO);
    }


    public ResponseEntity<AuthenticationResponse> loginCashier(CashierWVO cashierWVO) {
        try {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            cashierWVO.getMail(),
                            cashierWVO.getPassword()
                    )
            );
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>
                    (new AuthenticationResponse(null,
                            null, "Invalid email or password"), HttpStatus.UNAUTHORIZED);

        }
        CashierVO cashierVO = (CashierVO) cashierServiceImpl.findCashierByMail(cashierWVO.getMail()).orElseThrow();
        //            var cashierVO = cashierRepository.findByMail(cashierWVO.getMail()).orElseThrow();
        var jwToken = tokenServiceImpl.generateToken(cashierVO);
        var refreshToken = tokenServiceImpl.generateRefreshToken(cashierVO);

        revokeAllUserTokens(cashierVO.getUserVO());
        saveUserToken(cashierVO.getUserVO(), jwToken);
        return new ResponseEntity<>(new AuthenticationResponse(jwToken, refreshToken), HttpStatus.OK);
    }

    public ResponseEntity<AuthenticationResponse> loginAdmin(AdminWVO adminWVO) {
        try {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            adminWVO.getMail(),
                            adminWVO.getPassword()
                    )
            );
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>
                    (new AuthenticationResponse(null,
                            null, "Invalid email or password"), HttpStatus.UNAUTHORIZED);

        }
        AdminVO adminVO = (AdminVO) adminServiceImpl.findAdminByMail(adminWVO.getMail()).orElseThrow();
        var jwToken = tokenServiceImpl.generateToken(adminVO);
        var refreshToken = tokenServiceImpl.generateRefreshToken(adminVO);

        revokeAllUserTokens(adminVO.getUserVO());
        saveUserToken(adminVO.getUserVO(), jwToken);
        return new ResponseEntity<>(new AuthenticationResponse(jwToken, refreshToken), HttpStatus.OK);
    }

    public void revokeAllUserTokens(UserVO user) {
        var validUserTokens = tokenRepository.findByUser_IdAndRevokedAndExpired(user.getId(), false, false);
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshTokenCashier(HttpServletRequest request, HttpServletResponse response)
            throws IOException, java.io.IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null) {
                    
            return;

        }

        refreshToken = authHeader.substring(7);
        userEmail = tokenServiceImpl.extractUserMail(refreshToken);
        if (userEmail != null) {
            var cashierVO = (CashierVO) this.cashierServiceImpl.findCashierByMail(userEmail).orElseThrow();

            if (tokenServiceImpl.isTokenValid(refreshToken, cashierVO)) {
                var accessToken = tokenServiceImpl.generateToken(cashierVO);
                revokeAllUserTokens(cashierVO.getUserVO());
                saveUserToken(cashierVO.getUserVO(), accessToken);
                var authResponse = new AuthenticationResponse(accessToken, refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    public void refreshTokenAdmin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, java.io.IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null) {
            return;
        }

        refreshToken = authHeader.substring(7);
        userEmail = tokenServiceImpl.extractUserMail(refreshToken);
        if (userEmail != null) {
            var adminVO = (AdminVO) this.adminServiceImpl.findAdminByMail(userEmail).orElseThrow();
            if (tokenServiceImpl.isTokenValid(refreshToken, adminVO)) {
                var accessToken = tokenServiceImpl.generateToken(adminVO);
                revokeAllUserTokens(adminVO.getUserVO());
                saveUserToken(adminVO.getUserVO(), accessToken);
                var authResponse = new AuthenticationResponse(accessToken, refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

}
