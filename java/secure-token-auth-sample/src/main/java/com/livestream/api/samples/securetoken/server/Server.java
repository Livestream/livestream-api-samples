package com.livestream.api.samples.securetoken.server;

import static com.livestream.api.samples.securetoken.Constants.HOST;
import static com.livestream.api.samples.securetoken.Constants.PORT;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {

    public static String getServerAddress() {
        return "http://" + HOST + ":" + PORT;
    }
    
    public void start() {
        URI baseUri = UriBuilder.fromUri(getServerAddress() + "/").build();
        ResourceConfig config = new ResourceConfig();
        config.packages("com.livestream.api.samples.securetoken.server");
        JdkHttpServerFactory.createHttpServer(baseUri, config);
    }
    
    public static void main(String[] args) throws IOException {
        new Server().start();
        System.out.println("server started @ " + getServerAddress());
    }
}
