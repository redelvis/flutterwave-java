/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.examples;

import com.flutterwave.GetPaidCards;
import com.flutterwave.exceptions.EmptyKeyException;
import com.flutterwave.exceptions.InvalidRequestObjectException;
import com.flutterwave.requests.MVVARequest;
import com.flutterwave.response.MVVAResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author josepholaoye
 */
public class GetPaidCardsExample {

    MVVARequest request;

    public GetPaidCardsExample() {
        request = new MVVARequest();
        request.setAmount("1000.00");
        request.setAuthmodel("NOAUTH");
        request.setCardno("");
        request.setCountry("NG");
        request.setCurrency("NGN");
        request.setCustid("examplesspc");
        request.setExpirymonth("01");
        request.setExpiryyear("18");
        request.setMerchantid("lZBBPwc3kM");
        request.setNarration("A test payment");
        request.setCvv("354");
        request.setCvv("354");

        try {
            GetPaidCards getPaidCards = new GetPaidCards("OqjBHslUGvv6wSViNCCB", "lZBBPwc3kM", "http://staging1flutterwave.co:8080");
            MVVAResponse payWithCardDetails = getPaidCards.payWithCardDetails(request);
            String responseCode = payWithCardDetails.getResponseCode();
            Logger.getLogger(GetPaidCardsExample.class.getName()).log(Level.INFO, responseCode);
        } catch (EmptyKeyException | InvalidRequestObjectException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | IOException | URISyntaxException ex) {
            Logger.getLogger(GetPaidCardsExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}