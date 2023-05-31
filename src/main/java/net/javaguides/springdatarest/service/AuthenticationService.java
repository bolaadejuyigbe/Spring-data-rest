package net.javaguides.springdatarest.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.servlet.http.HttpServletRequest;
import net.javaguides.springdatarest.security.ApiKeyAuthentication;

public class AuthenticationService {
    private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
    private static final String  AUTH_TOKEN = "Baeldung";

    public static Authentication getAuthentication(HttpServletRequest request){
        String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
        if(apiKey== null || !apiKey.equals(AUTH_TOKEN)){
            throw new BadCredentialsException("Invalid apikey");
        }

        return new ApiKeyAuthentication(apiKey,AuthorityUtils.NO_AUTHORITIES);
    }
}