package com.example.Invoice.model.VO;


import jakarta.persistence.*;
import jdk.jshell.Snippet;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class InvoiceVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "INVOICE_DATE")
    private LocalDate invoiceDate;

    @Column(name = "TOTAL_AMOUNT_HT")
    private BigDecimal totalAmountHT;

    @Column(name = "TOTAL_AMOUNT_TTC")
    private BigDecimal getTotalAmountTTC;

    @Column(name = "PAYMENT_METHOD")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private StatusInvoice statusInvoice;

    @Column(name = "QRCODE")
    private String qrCode;

    @ManyToOne
    @JoinColumn(name = "ID_CASHIER", referencedColumnName = "ID")
    private CashierVO cashierVO;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
    private ClientVO clientVO;

    public InvoiceVO() {
    }

    public InvoiceVO(LocalDate invoiceDate, BigDecimal totalAmountHT,
                     BigDecimal getTotalAmountTTC, PaymentMethod paymentMethod,
                     StatusInvoice statusInvoice, CashierVO cashierVO, ClientVO clientVO) {
        this.invoiceDate = invoiceDate;
        this.totalAmountHT = totalAmountHT;
        this.getTotalAmountTTC = getTotalAmountTTC;
        this.paymentMethod = paymentMethod;
        this.statusInvoice = statusInvoice;
        this.cashierVO = cashierVO;
        this.clientVO = clientVO;
    }


    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getTotalAmountHT() {
        return totalAmountHT;
    }

    public void setTotalAmountHT(BigDecimal totalAmountHT) {
        this.totalAmountHT = totalAmountHT;
    }

    public BigDecimal getGetTotalAmountTTC() {
        return getTotalAmountTTC;
    }

    public void setGetTotalAmountTTC(BigDecimal getTotalAmountTTC) {
        this.getTotalAmountTTC = getTotalAmountTTC;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public StatusInvoice getStatusInvoice() {
        return statusInvoice;
    }

    public void setStatusInvoice(StatusInvoice statusInvoice) {
        this.statusInvoice = statusInvoice;
    }

    public CashierVO getCashierVO() {
        return cashierVO;
    }

    public void setCashierVO(CashierVO cashierVO) {
        this.cashierVO = cashierVO;
    }

    public ClientVO getClientVO() {
        return clientVO;
    }

    public void setClientVO(ClientVO clientVO) {
        this.clientVO = clientVO;
    }
}
