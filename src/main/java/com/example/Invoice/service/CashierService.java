package com.example.Invoice.service;

import com.example.Invoice.model.VO.CashierVO;

import java.util.Optional;

public interface CashierService {

   CashierVO saveCashier(CashierVO cashierVO);


    Optional<Object> findCashierByMail(String mail);

}
