package com.livestream.api.samples.securetoken.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.livestream.api.samples.securetoken.model.Token;

public class ClientApplication {

    private static final String CLIENT_ID = "[YOUR_CLIENT_ID]";
    private static final String LS_API_HOST = "https://livestreamapis.com/v1";
    private static final String GET_ACCOUNTS_URL = LS_API_HOST
            + "/accounts?token=%s&timestamp=%d&client_id=%s";
    private static final HttpClient client = HttpClientBuilder.create().build();

    public Token getTokenFromServer() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9998/tokens");
        Form form = new Form();
        form.param("ts", "" + System.currentTimeMillis());
        form.param("scope", "readonly");
        return target.request().post(
                Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), Token.class);
    }

    public String getAccountsJson(Token token) throws ClientProtocolException, IOException {
        HttpGet request = new HttpGet(String.format(GET_ACCOUNTS_URL, token.getToken(),
                token.getTimestamp(), CLIENT_ID));
        HttpResponse response = client.execute(request);
        return IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        ClientApplication clientApplication = new ClientApplication();
        try {
            Token token = clientApplication.getTokenFromServer();
            System.out.println("Got token from server => " + token);
            System.out.println("Fetching accounts using secure token");
            String jsonResponse = clientApplication.getAccountsJson(token);
            System.out.println("Got accounts response from Livestream Public API server => "
                    + jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
