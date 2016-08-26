/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.util.validators;

import com.flutterwave.requests.AccountRequest;

/**
 *
 * @author josepholaoye
 */
public class AccountValidator {
    public static boolean validate(AccountRequest request) {
        if (request == null) {
            return false;
        }
        else{
            //More Account validation like null checks can be written here.
            return true;
        }
    }
}
