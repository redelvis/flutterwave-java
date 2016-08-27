/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.examples;

import com.flutterwave.GetPaidAccounts;
import com.flutterwave.exceptions.EmptyKeyException;
import com.flutterwave.exceptions.InvalidRequestObjectException;
import com.flutterwave.requests.AccountRequest;
import com.flutterwave.response.AccountResponse;
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
public class GetPaidAccountsExample {
    AccountRequest accountRequest;

    public GetPaidAccountsExample() {
        accountRequest = new AccountRequest();
        accountRequest.setAccountNumber("0690000000");
        accountRequest.setBillingAmount("1000.00");
        accountRequest.setDebitNarration("A test payment");
        accountRequest.setMerchantid("lZBBPwc3kM");

        
        try {
            GetPaidAccounts getPaidAccounts = new GetPaidAccounts("OqjBHslUGvv6wSViNCCB", "lZBBPwc3kM", "http://staging1flutterwave.co:8080");
            AccountResponse initiate = getPaidAccounts.initiate(accountRequest);
           accountRequest.setReference(initiate.getTransactionReference());
        } catch (EmptyKeyException | InvalidRequestObjectException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | IOException | URISyntaxException ex) {
            Logger.getLogger(GetPaidAccountsExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
