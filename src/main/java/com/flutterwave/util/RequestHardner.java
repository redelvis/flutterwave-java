package com.flutterwave.util;

import com.flutterwave.requests.AccountRequest;
import com.flutterwave.requests.MVVARequest;

public class RequestHardner {

    private final TripleDES tripleDes;

    public RequestHardner(String apiKey) {
        tripleDes = new TripleDES(apiKey);
    }

    public MVVARequest MVVACardAPIHardner(MVVARequest mo) {
        MVVARequest mvo = new MVVARequest();

        mvo.setMerchantid(mo.getMerchantid());
        mvo.setAuthmodel(tripleDes.harden(mo.getAuthmodel()));
        mvo.setAmount(tripleDes.harden(mo.getAmount()));
        mvo.setCurrency(tripleDes.harden(mo.getCurrency()));
        mvo.setCurrency(tripleDes.harden(mo.getCurrency()));
        mvo.setCountry(tripleDes.harden(mo.getCountry()));
        mvo.setCardtype(tripleDes.harden(mo.getCardtype()));
        mvo.setCardno(tripleDes.harden(mo.getCardno()));
        mvo.setExpirymonth(tripleDes.harden(mo.getExpirymonth()));
        mvo.setExpiryyear(tripleDes.harden(mo.getExpiryyear()));
        mvo.setCustid(tripleDes.harden(mo.getCustid()));
        mvo.setNarration(tripleDes.harden(mo.getNarration()));
        mvo.setChargetoken(tripleDes.harden(mo.getChargetoken()));
        mvo.setCvv(tripleDes.harden(mo.getCvv()));
        mvo.setBvn(tripleDes.harden(mo.getBvn()));
        mvo.setPin(tripleDes.harden(mo.getPin()));
        mvo.setOtp(tripleDes.harden(mo.getOtp()));
        mvo.setOtptransactionidentifier(tripleDes.harden(mo.getOtptransactionidentifier()));
        mvo.setResponseurl(tripleDes.harden(mo.getResponseurl()));
        mvo.setValidateoption(tripleDes.harden(mo.getValidateoption()));
        mvo.setTrxauthorizeid(tripleDes.harden(mo.getTrxauthorizeid()));
        mvo.setTrxreference(tripleDes.harden(mo.getTrxreference()));

        return mvo;
    }

    public AccountRequest accountAPIHardner(AccountRequest rcr) {
        AccountRequest ro = new AccountRequest();

        ro.setAccountNumber(tripleDes.harden(rcr.getAccountNumber()));
        ro.setAccountToken(tripleDes.harden(rcr.getAccountToken()));
        ro.setBillingAmount(tripleDes.harden(rcr.getBillingAmount()));
        ro.setDebitNarration(tripleDes.harden(rcr.getDebitNarration()));
        ro.setOtp(tripleDes.harden(rcr.getOtp()));
        ro.setReference(tripleDes.harden(rcr.getReference()));

        return ro;
    }
}
