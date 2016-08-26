/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave;

import com.flutterwave.exceptions.EmptyKeyException;
import com.flutterwave.exceptions.InvalidRequestObjectException;
import com.flutterwave.requests.AccountRequest;
import com.flutterwave.response.AccountResponse;
import com.flutterwave.util.Gateway;
import com.flutterwave.util.RequestHardner;
import com.flutterwave.util.validators.AccountValidator;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author josepholaoye
 */
public class GetPaidAccounts {

    private String apiKey;
    private String merchantId;
    private String baseUrl;
    private RequestHardner hardner;

    public GetPaidAccounts(String apiKey, String merchantId, String baseUrl) throws EmptyKeyException {
        if (apiKey == null || apiKey.isEmpty() || merchantId == null || merchantId.isEmpty() || baseUrl == null || baseUrl.isEmpty()) {
            throw new EmptyKeyException();
        }
        this.apiKey = apiKey;
        this.merchantId = merchantId;
        this.baseUrl = baseUrl;
    }

    public AccountResponse initiate(AccountRequest request) throws InvalidRequestObjectException, BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, IOException, URISyntaxException {
        {
            AccountResponse response;
            boolean valid = AccountValidator.validate(request);
            if (!valid) {
                throw new InvalidRequestObjectException();
            } else {
                request = hardner.accountAPIHardner(request, apiKey);
                response = Gateway.sendAccountInitiate(request, merchantId, baseUrl);
                return response;
            }

        }
    }
    
    public AccountResponse validate(AccountRequest request) throws InvalidRequestObjectException, BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, IOException, URISyntaxException {
        {
            AccountResponse response;
            boolean valid = AccountValidator.validate(request);
            if (!valid) {
                throw new InvalidRequestObjectException();
            } else {
                request = hardner.accountAPIHardner(request, apiKey);
                response = Gateway.sendAccountValidate(request, merchantId, baseUrl);
                return response;
            }

        }
    }
    
    public AccountResponse charge(AccountRequest request) throws InvalidRequestObjectException, BadPaddingException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, IOException, URISyntaxException {
        {
            AccountResponse response;
            boolean valid = AccountValidator.validate(request);
            if (!valid) {
                throw new InvalidRequestObjectException();
            } else {
                request = hardner.accountAPIHardner(request, apiKey);
                response = Gateway.sendAccountCharge(request, merchantId, baseUrl);
                return response;
            }

        }
    }
}
