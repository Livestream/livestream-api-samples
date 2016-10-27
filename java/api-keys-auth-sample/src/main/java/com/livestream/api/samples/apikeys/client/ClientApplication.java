package com.livestream.api.samples.apikeys.client;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.livestream.api.samples.apikeys.server.Server;

public class ClientApplication {
    
    private static final String MY_API_ENDPOINT_URL = Server.getServerAddress() + "/accounts";
    private static final HttpClient client = HttpClientBuilder.create().build();

    public String getAccountsJson() throws ClientProtocolException, IOException {
        HttpGet request = new HttpGet(MY_API_ENDPOINT_URL);
        HttpResponse response = client.execute(request);
        return IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        ClientApplication clientApplication = new ClientApplication();
        try {
            String jsonResponse = clientApplication.getAccountsJson();
            System.out.println("Got accounts response from Livestream API server => "
                    + jsonResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
