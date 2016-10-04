package com.flutterwave.util;

import com.flutterwave.requests.AccountRequest;
import com.flutterwave.requests.MvvaRequest;

public class RequestEncrypter {

    private final TripleDES tripleDes;

    public RequestEncrypter(String apiKey) {
        tripleDes = new TripleDES(apiKey);
    }

    public MvvaRequest encryptMvvaCardRequest(MvvaRequest mo) {
        MvvaRequest mvo = new MvvaRequest();

        mvo.setMerchantid(mo.getMerchantid());
        mvo.setAuthmodel(tripleDes.encrypt(mo.getAuthmodel()));
        mvo.setAmount(tripleDes.encrypt(mo.getAmount()));
        mvo.setCurrency(tripleDes.encrypt(mo.getCurrency()));
        mvo.setCurrency(tripleDes.encrypt(mo.getCurrency()));
        mvo.setCountry(tripleDes.encrypt(mo.getCountry()));
        mvo.setCardtype(tripleDes.encrypt(mo.getCardtype()));
        mvo.setCardno(tripleDes.encrypt(mo.getCardno()));
        mvo.setExpirymonth(tripleDes.encrypt(mo.getExpirymonth()));
        mvo.setExpiryyear(tripleDes.encrypt(mo.getExpiryyear()));
        mvo.setCustid(tripleDes.encrypt(mo.getCustid()));
        mvo.setNarration(tripleDes.encrypt(mo.getNarration()));
        mvo.setChargetoken(tripleDes.encrypt(mo.getChargetoken()));
        mvo.setCvv(tripleDes.encrypt(mo.getCvv()));
        mvo.setBvn(tripleDes.encrypt(mo.getBvn()));
        mvo.setPin(tripleDes.encrypt(mo.getPin()));
        mvo.setOtp(tripleDes.encrypt(mo.getOtp()));
        mvo.setOtptransactionidentifier(tripleDes.encrypt(mo.getOtptransactionidentifier()));
        mvo.setResponseurl(tripleDes.encrypt(mo.getResponseurl()));
        mvo.setValidateoption(tripleDes.encrypt(mo.getValidateoption()));
        mvo.setTrxauthorizeid(tripleDes.encrypt(mo.getTrxauthorizeid()));
        mvo.setTrxreference(tripleDes.encrypt(mo.getTrxreference()));

        return mvo;
    }

    public AccountRequest encryptAccountRequest(AccountRequest rcr) {
        AccountRequest ro = new AccountRequest();
        ro.setMerchantid(rcr.getMerchantid());
        ro.setAccountNumber(tripleDes.encrypt(rcr.getAccountNumber()));
        ro.setAccountToken(tripleDes.encrypt(rcr.getAccountToken()));
        ro.setBillingAmount(tripleDes.encrypt(rcr.getBillingAmount()));
        ro.setDebitNarration(tripleDes.encrypt(rcr.getDebitNarration()));
        ro.setOtp(tripleDes.encrypt(rcr.getOtp()));
        ro.setReference(tripleDes.encrypt(rcr.getReference()));

        return ro;
    }
}
