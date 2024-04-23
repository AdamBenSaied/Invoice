package com.example.Invoice.controller;

import com.example.Invoice.service.ClientService;
import com.example.Invoice.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Invoice.constants.ENDPOINTS.CLIENT_ENDPOINT;

@RestController
@RequestMapping(path = CLIENT_ENDPOINT)
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;

    @Autowired

    public ClientController(ClientServiceImpl clientServiceImpl ) {
        this.clientServiceImpl = clientServiceImpl;
    }
}
