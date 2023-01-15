package com.csmarton.auth.web;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
public class UserRequest {

    @NotNull
    @JsonSetter("user")
    private final String username;

    @NotNull
    private final String password;


}
