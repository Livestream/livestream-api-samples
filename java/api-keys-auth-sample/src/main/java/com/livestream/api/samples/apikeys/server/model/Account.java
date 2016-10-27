package com.livestream.api.samples.apikeys.server.model;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    @JsonProperty
    private long id;
    @JsonProperty
    private String description;
    @JsonProperty
    private String email;
    @JsonProperty
    private String timezone;
    @JsonProperty
    private String fullName;
    @JsonProperty
    private String shortName;
    @JsonProperty
    private String createdAt;
}
