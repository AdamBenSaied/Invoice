package com.example.Invoice.model.WVO;


import com.example.Invoice.model.VO.PaymentMethod;
import com.example.Invoice.model.VO.StatusInvoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceWVO implements Serializable {

    private LocalDate invoiceDate;

    private BigDecimal totalAmountHT;

    private BigDecimal totalAmountTTC;

    private PaymentMethod paymentMethod;

    private StatusInvoice statusInvoice;

    private String qrCode;

    private CashierWVO cashierWVO;

    private ClientWVO clientWVO;

    public InvoiceWVO() {
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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public CashierWVO getCashierWVO() {
        return cashierWVO;
    }

    public void setCashierWVO(CashierWVO cashierWVO) {
        this.cashierWVO = cashierWVO;
    }

    public ClientWVO getClientWVO() {
        return clientWVO;
    }

    public void setClientWVO(ClientWVO clientWVO) {
        this.clientWVO = clientWVO;
    }


}
