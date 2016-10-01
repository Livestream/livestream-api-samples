package com.livestream.api.samples.apikeys.server;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
    public void start() {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig();
        config.packages("com.livestream.api.samples.apikeys.server");
        JdkHttpServerFactory.createHttpServer(baseUri, config);
    }
    
    public static void main(String[] args) throws IOException {
        new Server().start();
        System.out.println("server started");
    }
}
