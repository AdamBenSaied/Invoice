package com.example.Invoice.controller;

import com.example.Invoice.service.ProductService;
import com.example.Invoice.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.Invoice.constants.ENDPOINTS.PRODUCT_ENDPOINT;

@RestController
@RequestMapping(path = PRODUCT_ENDPOINT)
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }
}
