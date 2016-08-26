/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.util.validators;

import com.flutterwave.requests.MVVARequest;

/**
 *
 * @author josepholaoye
 */
public class MVVAValidator {

    public static boolean validate(MVVARequest request) {
        if (request == null) {
            return false;
        }
        else{
            //More MVVA validation like Luhn check and null checks can be written here.
            return true;
        }
    }

}
