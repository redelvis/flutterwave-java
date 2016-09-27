package com.flutterwave.util.validators;

import com.flutterwave.requests.MvvaRequest;

public class MVVAValidator {

    public static boolean validate(MvvaRequest request) {
        return request != null && request.getMerchantid() != null;
    }

}
