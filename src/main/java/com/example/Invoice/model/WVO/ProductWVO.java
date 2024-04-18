package com.example.Invoice.model.WVO;

import com.example.Invoice.model.VO.StatusProducts;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductWVO implements Serializable {

    private String name;

    private String description;
    private BigDecimal price;
    private Integer tax;

   private StatusProducts statusProducts;

    private Integer stock;


}
