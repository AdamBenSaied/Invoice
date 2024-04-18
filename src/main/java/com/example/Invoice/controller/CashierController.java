package com.example.Invoice.controller;

import com.example.Invoice.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Invoice.constants.ENDPOINTS.CASHIER_ENDPOINT;

@RestController
@RequestMapping(path = CASHIER_ENDPOINT)
public class CashierController {

    private CashierService cashierService;

    @Autowired
    public CashierController(CashierService cashierService) {
        this.cashierService = cashierService;
    }

}
