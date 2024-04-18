package com.example.Invoice.service;

import com.example.Invoice.repository.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashierService {

    private CashierRepository cashierRepository;

    @Autowired
    public CashierService(CashierRepository cashierRepository) {
        this.cashierRepository = cashierRepository;
    }
}
