/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.requests;

/**
 *
 * @author josepholaoye
 */
public class AccountRequest {

    private String accountNumber;
    private String merchantid;
    private String otp;
    private String reference;
    private String debitNarration;
    private String accountToken;
    private String billingAmount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDebitNarration() {
        return debitNarration;
    }

    public void setDebitNarration(String debitnarration) {
        this.debitNarration = debitnarration;
    }

    public String getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }

    public String getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(String billingamount) {
        this.billingAmount = billingamount;
    }
    
    
}
