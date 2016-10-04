package com.flutterwave.examples;

import com.flutterwave.exceptions.EmptyKeyException;
import com.flutterwave.exceptions.InvalidRequestObjectException;
import com.flutterwave.requests.WithdrawalRequest;
import com.flutterwave.response.MVVAResponse;
import com.flutterwave.response.WithdrawalResponse;
import com.flutterwave.util.Gateway;
import com.flutterwave.util.RequestEncrypter;
import com.flutterwave.util.TripleDES;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WithdrawalCardsExample {
    private static final Logger logger = Logger.getLogger(WithdrawalCardsExample.class.getName());

    public static void main(String[] args) {
        WithdrawalRequest request = new WithdrawalRequest();
        request.setAmount("1000.00");
        request.setAccountNumber("accno");
        request.setValidateOption("EMAIL");
        request.setTrxReference("trxreference");
        request.setMerchantid("lZBBPwc3kM");

        TripleDES requestEncrypter = new TripleDES("OqjBHslUGvv6wSViNCCB");
        Gateway gateway = new Gateway("lZBBPwc3kM", "http://staging1flutterwave.co:8080");
        request.setAccountNumber(requestEncrypter.encrypt(request.getAccountNumber()));
        request.setAmount(requestEncrypter.encrypt(request.getAmount()));
        request.setValidateOption(requestEncrypter.encrypt(request.getValidateOption()));
        request.setTrxReference(requestEncrypter.encrypt(request.getTrxReference()));
        WithdrawalResponse response = gateway.withdrawal(request);
        logger.log(Level.INFO, "status: " + response.getStatus());
    }
}
