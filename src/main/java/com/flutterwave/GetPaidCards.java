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
    private RequestEncrypter hardner;

    public GetPaidCards(String apiKey, String merchantId, String baseUrl) throws EmptyKeyException {
        if (apiKey == null || apiKey.isEmpty() || merchantId == null || merchantId.isEmpty() || baseUrl == null || baseUrl.isEmpty()) {
            throw new EmptyKeyException();
        }
        this.apiKey = apiKey;
        this.merchantId = merchantId;
        this.baseUrl = baseUrl;
        hardner = new RequestEncrypter(apiKey);
    }

    public MVVAResponse payWithCardDetails(MvvaRequest request) throws InvalidRequestObjectException {
        MVVAResponse response;
        boolean valid = MVVAValidator.validate(request);
        if (!valid) {
            throw new InvalidRequestObjectException();
        } else {
            request = hardner.encryptMvvaCardRequest(request);
            response = Gateway.sendMCD(request, merchantId, baseUrl);
            return response;
        }
    }

    public MVVAResponse payWithToken(MvvaRequest request) throws InvalidRequestObjectException {
        MVVAResponse response;
        boolean valid = MVVAValidator.validate(request);
        if (!valid) {
            throw new InvalidRequestObjectException();
        } else {
            request = hardner.encryptMvvaCardRequest(request);
            response = Gateway.sendMT(request, merchantId, baseUrl);
            return response;
        }
    }

    public MVVAResponse validate(MvvaRequest request) throws InvalidRequestObjectException {
        MVVAResponse response;
        boolean valid = MVVAValidator.validate(request);
        if (!valid) {
            throw new InvalidRequestObjectException();
        } else {
            request = hardner.encryptMvvaCardRequest(request);
            response = Gateway.sendVT(request, merchantId, baseUrl);
            return response;
        }
    }

}
