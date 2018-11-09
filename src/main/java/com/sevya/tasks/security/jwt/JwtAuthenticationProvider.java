package com.sevya.tasks.security.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final JwtService jwtService;

    @SuppressWarnings("unused")
    public JwtAuthenticationProvider() {
        this(null);
    }

    @Autowired
    public JwtAuthenticationProvider(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
        	JwtAuthenticatedUserDto jwtAuthenticatedUserDto = jwtService.verify((String) authentication.getCredentials());
            return new JwtAuthenticatedProfile(jwtAuthenticatedUserDto);
        } catch (Exception e) {
        	if(e.getMessage().contains("Please verify your token")){
        		throw new JwtAuthenticationException("Please verify your token", new Exception("Please verify your token...!!"));
        	}
            throw new JwtAuthenticationException("Failed to verify token", new Exception("Token Expired...!!"));
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthToken.class.equals(authentication);
    }
}