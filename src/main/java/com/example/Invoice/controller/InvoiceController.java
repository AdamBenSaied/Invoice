package com.example.Invoice.controller;

import com.example.Invoice.service.InvoiceService;
import com.example.Invoice.service.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Invoice.constants.ENDPOINTS.INVOICE_ENDPOINT;

@RestController
@RequestMapping(path = INVOICE_ENDPOINT)
public class InvoiceController {

    private final InvoiceServiceImpl invoiceServiceImpl;

    @Autowired
    public InvoiceController(InvoiceServiceImpl invoiceServiceImpl) {
        this.invoiceServiceImpl = invoiceServiceImpl;
    }


}
