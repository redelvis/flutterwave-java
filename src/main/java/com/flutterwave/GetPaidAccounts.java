package com.flutterwave;

import com.flutterwave.exceptions.EmptyKeyException;
import com.flutterwave.exceptions.InvalidRequestObjectException;
import com.flutterwave.requests.AccountRequest;
import com.flutterwave.response.AccountResponse;
import com.flutterwave.util.Gateway;
import com.flutterwave.util.RequestEncrypter;
import com.flutterwave.util.validators.AccountValidator;

public class GetPaidAccounts {

    private String apiKey;
    private String merchantId;
    private String baseUrl;
    private RequestEncrypter hardner;
    private Gateway gateway;

    public GetPaidAccounts(String apiKey, String merchantId, String baseUrl) throws EmptyKeyException {
        if (apiKey == null || apiKey.isEmpty() || merchantId == null || merchantId.isEmpty() || baseUrl == null || baseUrl.isEmpty()) {
            throw new EmptyKeyException();
        }
        this.apiKey = apiKey;
        this.merchantId = merchantId;
        this.baseUrl = baseUrl;
        this.hardner = new RequestEncrypter(apiKey);
        gateway = new Gateway(baseUrl);
    }

    public AccountResponse initiate(AccountRequest request) throws InvalidRequestObjectException {
        {
            if (!AccountValidator.validate(request)) {
                throw new InvalidRequestObjectException();
            }
            AccountRequest encryptedRequest = hardner.encryptAccountRequest(request);
            AccountResponse response = gateway.sendAccountInitiate(encryptedRequest);
            return response;
        }
    }

    public AccountResponse validate(AccountRequest request) throws InvalidRequestObjectException {
        {
            if (!AccountValidator.validate(request)) {
                throw new InvalidRequestObjectException();
            }
            AccountRequest encryptedRequest = hardner.encryptAccountRequest(request);
            AccountResponse response = gateway.sendAccountValidate(encryptedRequest);
            return response;

        }
    }

    public AccountResponse charge(AccountRequest request) throws InvalidRequestObjectException {
        {
            if (!AccountValidator.validate(request)) {
                throw new InvalidRequestObjectException();
            }
            AccountRequest encryptedRequest = hardner.encryptAccountRequest(request);
            AccountResponse response = gateway.sendAccountCharge(encryptedRequest);
            return response;

        }
    }
}
