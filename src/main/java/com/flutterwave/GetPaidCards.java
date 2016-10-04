package com.flutterwave;

import com.flutterwave.exceptions.EmptyKeyException;
import com.flutterwave.exceptions.InvalidRequestObjectException;
import com.flutterwave.requests.MvvaRequest;
import com.flutterwave.response.MVVAResponse;
import com.flutterwave.util.Gateway;
import com.flutterwave.util.RequestEncrypter;
import com.flutterwave.util.validators.MVVAValidator;

public class GetPaidCards {
    private String apiKey;
    private String merchantId;
    private String baseUrl;
    private RequestEncrypter requestEncrypter;
    private Gateway gateway;

    public GetPaidCards(String apiKey, String merchantId, String baseUrl) throws EmptyKeyException {
        if (apiKey == null || apiKey.isEmpty() || merchantId == null || merchantId.isEmpty() || baseUrl == null || baseUrl.isEmpty()) {
            throw new EmptyKeyException();
        }
        this.apiKey = apiKey;
        this.merchantId = merchantId;
        this.baseUrl = baseUrl;
        requestEncrypter = new RequestEncrypter(this.apiKey);
        gateway = new Gateway(baseUrl);
    }

    public MVVAResponse payWithCardDetails(MvvaRequest request) throws InvalidRequestObjectException {
        if (!MVVAValidator.validate(request)) {
            throw new InvalidRequestObjectException();
        }
        MvvaRequest encryptedRequest = requestEncrypter.encryptMvvaCardRequest(request);
        MVVAResponse response = gateway.sendPayWithCardDetailsRequest(encryptedRequest);
        return response;
    }

    public MVVAResponse payWithToken(MvvaRequest request) throws InvalidRequestObjectException {
        if (!MVVAValidator.validate(request)) {
            throw new InvalidRequestObjectException();
        }
        MvvaRequest encryptedRequest = requestEncrypter.encryptMvvaCardRequest(request);
        MVVAResponse response = gateway.sendPayWithTokenRequest(encryptedRequest);
        return response;
    }

    public MVVAResponse validate(MvvaRequest request) throws InvalidRequestObjectException {
        if (!MVVAValidator.validate(request)) {
            throw new InvalidRequestObjectException();
        }
        MvvaRequest encryptedRequest = requestEncrypter.encryptMvvaCardRequest(request);
        MVVAResponse response = gateway.sendValidateRequest(encryptedRequest);
        return response;
    }

}
