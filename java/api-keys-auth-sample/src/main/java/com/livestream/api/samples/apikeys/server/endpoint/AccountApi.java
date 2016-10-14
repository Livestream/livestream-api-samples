package com.livestream.api.samples.apikeys.server.endpoint;

import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.apache.http.client.*;

import com.livestream.api.samples.apikeys.server.LivestreamApiService;

@Path("")
public class AccountApi {
    
    @Path("/accounts")
    @GET
    public Response getAccounts() throws ClientProtocolException, IOException {
        try {
            return Response.ok(LivestreamApiService.getAccounts(), MediaType.APPLICATION_JSON_TYPE).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.serverError().entity("Backend error").build();
    }
}