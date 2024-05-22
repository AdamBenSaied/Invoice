package com.example.Invoice.service;

import com.example.Invoice.model.VO.CashierVO;
import com.example.Invoice.repository.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CashierServiceImpl implements CashierService {

    private final CashierRepository cashierRepository;

    @Autowired
    public CashierServiceImpl(CashierRepository cashierRepository) {
        this.cashierRepository = cashierRepository;
    }


    public CashierVO saveCashier(CashierVO cashierVO) {
        return cashierRepository.saveAndFlush(cashierVO);
    }

    @Override
    public Optional<Object> findCashierByMail(String mail) {
        return cashierRepository.findByMail(mail);
    }


}
