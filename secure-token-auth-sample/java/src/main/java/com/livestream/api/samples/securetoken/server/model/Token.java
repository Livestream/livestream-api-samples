package com.livestream.api.samples.securetoken.server.model;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {
    @JsonProperty
    private String token;
    @JsonProperty
    private long timestamp;
    
    public Token(String token, long timestamp) {
        this.token = token;
        this.timestamp = timestamp;
    }
}
