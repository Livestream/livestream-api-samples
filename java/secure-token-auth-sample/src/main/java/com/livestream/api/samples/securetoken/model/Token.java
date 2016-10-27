package com.livestream.api.samples.securetoken.model;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {
    private String token;
    private long timestamp;
    
    public Token() {
    }
    
    public Token(String token, long timestamp) {
        this.token = token;
        this.timestamp = timestamp;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Token [token=");
        builder.append(token);
        builder.append(", timestamp=");
        builder.append(timestamp);
        builder.append("]");
        return builder.toString();
    }
}
