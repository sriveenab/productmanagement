package com.sevya.tasks.security.jwt;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Component;

@Component
public class SecretKeyProvider {
	
    public byte[] getKey() throws URISyntaxException, IOException {
    	return "sevya".getBytes();
    }
}
