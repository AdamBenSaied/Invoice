package com.example.Invoice.model.VO;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "products")
public class ProductVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "TAX")
    private Integer tax;

    @Column(name = "STATUS")
    StatusProducts statusProducts;

    @Column(name = "STOCK")
    Integer stock;

    public ProductVO() {
    }

    public ProductVO(String name, String description, BigDecimal price,
                     Integer tax, StatusProducts statusProducts, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.tax = tax;
        this.statusProducts = statusProducts;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public StatusProducts getStatusProducts() {
        return statusProducts;
    }

    public void setStatusProducts(StatusProducts statusProducts) {
        this.statusProducts = statusProducts;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
