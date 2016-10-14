package com.livestream.api.samples.securetoken.server.endpoint;

import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.apache.http.client.*;

import com.livestream.api.samples.securetoken.server.*;

@Path("")
public class TokenApi {
    
    @Path("/tokens")
    @POST
    public Response generateToken(@FormParam("scope") String scope, @FormParam("ts") long timestamp) throws ClientProtocolException, IOException {
        try {
            return Response.ok(TokenService.generateToken(scope, timestamp), MediaType.APPLICATION_JSON_TYPE).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.serverError().entity("Backend error").build();
    }
}