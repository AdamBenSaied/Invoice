package com.example.Invoice.model.VO;


import jakarta.persistence.*;

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
    private BigDecimal totalAmountTTC;

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
                     BigDecimal totalAmountTTC, PaymentMethod paymentMethod,
                     StatusInvoice statusInvoice, CashierVO cashierVO, ClientVO clientVO) {
        this.invoiceDate = invoiceDate;
        this.totalAmountHT = totalAmountHT;
        this.totalAmountTTC = totalAmountTTC;
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

    public BigDecimal getTotalAmountTTC() {
        return totalAmountTTC;
    }

    public void setTotalAmountTTC(BigDecimal totalAmountTTC) {
        this.totalAmountTTC = totalAmountTTC;
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
