package com.flutterwave.util.validators;

import com.flutterwave.requests.MvvaRequest;

/**
 *
 * @author josepholaoye
 */
public class MVVAValidator {

    public static boolean validate(MvvaRequest request) {
        if (request == null) {
            return false;
        }
        else{
            //More MVVA validation like Luhn check and null checks can be written here.
            return true;
        }
    }

}
