/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.exceptions;

/**
 *
 * @author josepholaoye
 */
public class EmptyKeyException extends Exception{

    @Override
    public String getMessage() {
        return "Empty API Key or Merchant Id supplied";
    }
    
    
}
