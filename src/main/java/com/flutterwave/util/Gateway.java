/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flutterwave.util;

import com.flutterwave.requests.AccountRequest;
import com.flutterwave.requests.MVVARequest;
import com.flutterwave.response.AccountResponse;
import com.flutterwave.response.MVVAResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author josepholaoye
 */
public class Gateway {

    public static MVVAResponse sendMCD(MVVARequest request, String merchantId, String baseUrl) throws URISyntaxException, UnsupportedEncodingException, IOException, JSONException {
        String url = baseUrl.concat("/pwc/rest/card/mvva/pay");
        JSONObject requestJSON = new JSONObject();
        requestJSON.putOpt("amount", request.getAmount());
        requestJSON.putOpt("authmodel", request.getAuthmodel());
        requestJSON.putOpt("cardno", request.getCardno());
        requestJSON.putOpt("currency", request.getCurrency());
        requestJSON.putOpt("custid", request.getCustid());
        requestJSON.putOpt("country", request.getCountry());
        requestJSON.putOpt("cvv", request.getCvv());
        requestJSON.putOpt("pin", request.getPin());
        requestJSON.putOpt("bvn", request.getBvn());
        requestJSON.putOpt("cardtype", request.getCardtype());
        requestJSON.putOpt("expirymonth", request.getExpirymonth());
        requestJSON.putOpt("expiryyear", request.getExpiryyear());
        requestJSON.putOpt("merchantid", merchantId);
        requestJSON.putOpt("narration", request.getNarration());
        requestJSON.putOpt("responseurl", request.getResponseurl());

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(url);
        HttpPost post = new HttpPost(builder.build());
        post.setEntity(new StringEntity(requestJSON.toString()));
        HttpResponse httpResponse = client.execute(post);
        HttpEntity responseEntity = httpResponse.getEntity();
        if (responseEntity != null) {
            String output = EntityUtils.toString(responseEntity);
            JSONObject details = new JSONObject(output);
            MVVAResponse response = Util.makeMVVAResponse(details);
            return response;
        } else {
            return null;
        }
    }

    public static MVVAResponse sendMT(MVVARequest request, String merchantId, String baseUrl) throws URISyntaxException, UnsupportedEncodingException, IOException, JSONException {
        String url = baseUrl.concat("/pwc/rest/card/mvva/pay");
        JSONObject requestJSON = new JSONObject();
        requestJSON.putOpt("amount", request.getAmount());
        requestJSON.putOpt("currency", request.getCurrency());
        requestJSON.putOpt("custid", request.getCustid());
        requestJSON.putOpt("country", request.getCountry());
        requestJSON.putOpt("cardtype", request.getCardtype());
        requestJSON.putOpt("narration", request.getNarration());
        requestJSON.putOpt("chargetoken", request.getChargetoken());
        requestJSON.putOpt("merchantid", merchantId);

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(url);
        HttpPost post = new HttpPost(builder.build());
        post.setEntity(new StringEntity(requestJSON.toString()));
        HttpResponse httpResponse = client.execute(post);
        HttpEntity responseEntity = httpResponse.getEntity();
        if (responseEntity != null) {
            String output = EntityUtils.toString(responseEntity);
            JSONObject details = new JSONObject(output);
            MVVAResponse response = Util.makeMVVAResponse(details);
            return response;
        } else {
            return null;
        }
    }

    public static MVVAResponse sendVT(MVVARequest request, String merchantId, String baseUrl) throws URISyntaxException, UnsupportedEncodingException, IOException, JSONException {

        String url = baseUrl.concat("/pwc/rest/card/mvva/pay");
        JSONObject requestJSON = new JSONObject();
        requestJSON.putOpt("otp", request.getOtp());
        requestJSON.putOpt("otptransactionidentifier", request.getOtptransactionidentifier());
        requestJSON.putOpt("country", request.getCountry());
        requestJSON.putOpt("cardtype", request.getCardtype());
        requestJSON.putOpt("merchantid", merchantId);

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(url);
        HttpPost post = new HttpPost(builder.build());
        post.setEntity(new StringEntity(requestJSON.toString()));
        HttpResponse httpResponse = client.execute(post);
        HttpEntity responseEntity = httpResponse.getEntity();
        if (responseEntity != null) {
            String output = EntityUtils.toString(responseEntity);
            JSONObject details = new JSONObject(output);
            MVVAResponse response = Util.makeMVVAResponse(details);
            return response;
        } else {
            return null;
        }

    }

    public static AccountResponse sendAccountInitiate(AccountRequest request, String merchantId, String baseUrl) throws URISyntaxException, UnsupportedEncodingException, IOException, JSONException {

        String url = baseUrl.concat("/pwc/rest/recurrent/account");
        JSONObject requestJSON = new JSONObject();
        requestJSON.putOpt("accountNumber", request.getAccountNumber());
        requestJSON.putOpt("merchantid", merchantId);

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(url);
        HttpPost post = new HttpPost(builder.build());
        post.setEntity(new StringEntity(requestJSON.toString()));
        HttpResponse httpResponse = client.execute(post);
        HttpEntity responseEntity = httpResponse.getEntity();
        if (responseEntity != null) {
            String output = EntityUtils.toString(responseEntity);
            JSONObject details = new JSONObject(output);
            AccountResponse response = Util.makeAccountResponse(details);
            return response;
        } else {
            return null;
        }

    }

    public static AccountResponse sendAccountValidate(AccountRequest request, String merchantId, String baseUrl) throws URISyntaxException, UnsupportedEncodingException, IOException, JSONException {

        String url = baseUrl.concat("/pwc/rest/recurrent/account/validate");
        JSONObject requestJSON = new JSONObject();
        requestJSON.putOpt("accountNumber", request.getAccountNumber());
        requestJSON.putOpt("otp", request.getOtp());
        requestJSON.putOpt("reference", request.getReference());
        requestJSON.putOpt("billingamount", request.getBillingAmount());
        requestJSON.putOpt("debitnarration", request.getDebitNarration());
        requestJSON.putOpt("merchantid", merchantId);

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(url);
        HttpPost post = new HttpPost(builder.build());
        post.setEntity(new StringEntity(requestJSON.toString()));
        HttpResponse httpResponse = client.execute(post);
        HttpEntity responseEntity = httpResponse.getEntity();
        if (responseEntity != null) {
            String output = EntityUtils.toString(responseEntity);
            JSONObject details = new JSONObject(output);
            AccountResponse response = Util.makeAccountResponse(details);
            return response;
        } else {
            return null;
        }
    }

    public static AccountResponse sendAccountCharge(AccountRequest request, String merchantId, String baseUrl) throws URISyntaxException, UnsupportedEncodingException, IOException, JSONException {

        String url = baseUrl.concat("/pwc/rest/recurrent/account/charge");
        JSONObject requestJSON = new JSONObject();
        requestJSON.putOpt("accountToken", request.getAccountNumber());
        requestJSON.putOpt("billingamount", request.getBillingAmount());
        requestJSON.putOpt("debitnarration", request.getDebitNarration());
        requestJSON.putOpt("merchantid", merchantId);

        HttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder(url);
        HttpPost post = new HttpPost(builder.build());
        post.setEntity(new StringEntity(requestJSON.toString()));
        HttpResponse httpResponse = client.execute(post);
        HttpEntity responseEntity = httpResponse.getEntity();
        if (responseEntity != null) {
            String output = EntityUtils.toString(responseEntity);
            JSONObject details = new JSONObject(output);
            AccountResponse response = Util.makeAccountResponse(details);
            return response;
        } else {
            return null;
        }
    }

}
