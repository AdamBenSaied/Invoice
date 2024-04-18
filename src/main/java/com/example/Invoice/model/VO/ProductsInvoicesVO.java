package com.example.Invoice.model.VO;


import jakarta.persistence.*;

@Entity
@Table(name = "products_invoices")
public class ProductsInvoicesVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT")
    private ProductVO productVO;

    @ManyToOne
    @JoinColumn(name = "ID_INVOICE")
    private  InvoiceVO invoiceVO;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DISCOUNT")
    private Double discount;

    public ProductsInvoicesVO() {
    }

    public ProductsInvoicesVO(ProductVO productVO, InvoiceVO invoiceVO, Integer quantity, Double discount) {
        this.productVO = productVO;
        this.invoiceVO = invoiceVO;
        this.quantity = quantity;
        this.discount = discount;
    }

    public ProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ProductVO productVO) {
        this.productVO = productVO;
    }

    public InvoiceVO getInvoiceVO() {
        return invoiceVO;
    }

    public void setInvoiceVO(InvoiceVO invoiceVO) {
        this.invoiceVO = invoiceVO;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
