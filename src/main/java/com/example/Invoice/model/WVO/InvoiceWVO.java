package com.example.Invoice.model.WVO;

import com.example.Invoice.model.VO.CashierVO;
import com.example.Invoice.model.VO.ClientVO;
import com.example.Invoice.model.VO.PaymentMethod;
import com.example.Invoice.model.VO.StatusInvoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceWVO implements Serializable {

    private LocalDate invoiceDate;

    private BigDecimal totalAmountHT;

    private BigDecimal getTotalAmountTTC;

    private PaymentMethod paymentMethod;

    private StatusInvoice statusInvoice;

    private String qrCode;

    private CashierVO cashierVO;

    private ClientVO clientVO;

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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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
