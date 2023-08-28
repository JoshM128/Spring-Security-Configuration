package com.Authentication.SpringSecurity.Authentication;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;


    @JsonProperty("refresh_token")
    private String refreshToken;
}
