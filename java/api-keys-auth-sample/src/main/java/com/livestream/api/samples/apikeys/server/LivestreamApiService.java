package com.livestream.api.samples.apikeys.server;

import static com.livestream.api.samples.apikeys.Constants.API_SECRET;

import java.io.IOException;
import java.util.List;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.glassfish.jersey.internal.util.Base64;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.livestream.api.samples.apikeys.server.model.Account;

public class LivestreamApiService {

    private static final String LS_API_HOST = "https://livestreamapis.com/v1";
    private static final String GET_ACCOUNTS_URL = LS_API_HOST + "/accounts";
    private static final Header AUTHORIZATION = new BasicHeader("Authorization",
            Base64.encodeAsString(API_SECRET));

    private static final HttpClient client = HttpClientBuilder.create().build();

    private static <T> T parseResponseAs(HttpResponse response, TypeReference<T> typeRef)
            throws JsonParseException, JsonMappingException, UnsupportedOperationException,
            IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getEntity().getContent(), typeRef);
    }

    public static List<Account> getAccounts() throws ClientProtocolException, IOException {
        HttpGet request = new HttpGet(GET_ACCOUNTS_URL);
        request.addHeader(AUTHORIZATION);
        HttpResponse response = client.execute(request);
        return parseResponseAs(response, new TypeReference<List<Account>>() {});
    }
}
