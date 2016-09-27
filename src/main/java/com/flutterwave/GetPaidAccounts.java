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

    public GetPaidAccounts(String apiKey, String merchantId, String baseUrl) throws EmptyKeyException {
        if (apiKey == null || apiKey.isEmpty() || merchantId == null || merchantId.isEmpty() || baseUrl == null || baseUrl.isEmpty()) {
            throw new EmptyKeyException();
        }
        this.apiKey = apiKey;
        this.merchantId = merchantId;
        this.baseUrl = baseUrl;
        this.hardner = new RequestEncrypter(apiKey);
    }

    public AccountResponse initiate(AccountRequest request) throws InvalidRequestObjectException {
        {
            AccountResponse response;
            boolean valid = AccountValidator.validate(request);
            if (!valid) {
                throw new InvalidRequestObjectException();
            } else {
                request = hardner.accountAPIHardner(request);
                response = Gateway.sendAccountInitiate(request, merchantId, baseUrl);
                return response;
            }

        }
    }

    public AccountResponse validate(AccountRequest request) throws InvalidRequestObjectException {
        {
            AccountResponse response;
            boolean valid = AccountValidator.validate(request);
            if (!valid) {
                throw new InvalidRequestObjectException();
            } else {
                request = hardner.accountAPIHardner(request);
                response = Gateway.sendAccountValidate(request, merchantId, baseUrl);
                return response;
            }

        }
    }

    public AccountResponse charge(AccountRequest request) throws InvalidRequestObjectException {
        {
            AccountResponse response;
            boolean valid = AccountValidator.validate(request);
            if (!valid) {
                throw new InvalidRequestObjectException();
            } else {
                request = hardner.accountAPIHardner(request);
                response = Gateway.sendAccountCharge(request, merchantId, baseUrl);
                return response;
            }

        }
    }
}
