package com.flutterwave.util;

import com.flutterwave.requests.AccountRequest;
import com.flutterwave.requests.MVVARequest;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author josepholaoye
 */
public class RequestHardner {

    private TripleDES tripleDes;

    public MVVARequest MVVACardAPIHardner(MVVARequest mo, String key) throws BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException {
        MVVARequest mvo = new MVVARequest();
        tripleDes = new TripleDES(key);

        mvo.setCardno(tripleDes.harden(mo.getCardno()));
        mvo.setAmount(tripleDes.harden(mo.getAmount()));
        mvo.setBvn(tripleDes.harden(mo.getBvn()));
        mvo.setChargetoken(tripleDes.harden(mo.getChargetoken()));
        mvo.setCurrency(tripleDes.harden(mo.getCurrency()));
        mvo.setCurrency(tripleDes.harden(mo.getCurrency()));
        mvo.setCustid(tripleDes.harden(mo.getCustid()));
        mvo.setCvv(tripleDes.harden(mo.getCvv()));
        mvo.setExpirymonth(tripleDes.harden(mo.getExpirymonth()));
        mvo.setExpiryyear(tripleDes.harden(mo.getExpiryyear()));
        mvo.setNarration(tripleDes.harden(mo.getNarration()));
        mvo.setOtp(tripleDes.harden(mo.getOtp()));
        mvo.setOtptransactionidentifier(tripleDes.harden(mo.getOtptransactionidentifier()));
        mvo.setPin(tripleDes.harden(mo.getPin()));
        mvo.setAuthmodel(tripleDes.harden(mo.getAuthmodel()));
        mvo.setResponseurl(tripleDes.harden(mo.getResponseurl()));
        mvo.setValidateoption(tripleDes.harden(mo.getValidateoption()));
        mvo.setTrxauthorizeid(tripleDes.harden(mo.getTrxauthorizeid()));
        mvo.setTrxreference(tripleDes.harden(mo.getTrxreference()));
        mvo.setCardtype(tripleDes.harden(mo.getCardtype()));
        mvo.setCountry(tripleDes.harden(mo.getCountry()));
        return mvo;

    }

    public AccountRequest accountAPIHardner(AccountRequest rcr, String key)throws BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException {
        AccountRequest ro = new AccountRequest();
        tripleDes = new TripleDES(key);
        
        ro.setAccountNumber(tripleDes.harden(rcr.getAccountNumber()));
        ro.setAccountToken(tripleDes.harden(rcr.getAccountToken()));
        ro.setBillingAmount(tripleDes.harden(rcr.getBillingAmount()));
        ro.setDebitNarration(tripleDes.harden(rcr.getDebitNarration()));
        ro.setOtp(tripleDes.harden(rcr.getOtp()));
        ro.setReference(tripleDes.harden(rcr.getReference()));

        return ro;
    }
}
