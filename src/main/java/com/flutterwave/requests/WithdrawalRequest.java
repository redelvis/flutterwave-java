package com.flutterwave.requests;

public class WithdrawalRequest {
    private String amount;
    private String accountNumber;
    private String validateOption;
    private String trxReference;
    private String merchantid;

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setValidateOption(String validateOption) {
        this.validateOption = validateOption;
    }

    public String getValidateOption() {
        return validateOption;
    }

    public void setTrxReference(String trxReference) {
        this.trxReference = trxReference;
    }

    public String getTrxReference() {
        return trxReference;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid;
    }

    public String getMerchantid() {
        return merchantid;
    }
}
