package com.livestream.api.samples.server.endpoint;

import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.apache.http.client.*;

import com.livestream.api.samples.server.LivestreamApiService;

@Path("")
public class AccountApi {
    
    @Path("/accounts")
    @GET
    public Response getAccounts() throws ClientProtocolException, IOException {
        try {
            Response.ok(LivestreamApiService.getAccounts(), MediaType.APPLICATION_JSON_TYPE).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.serverError().entity("Backend error").build();
    }
}