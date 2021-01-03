package com.medium.client.utils;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

import static com.medium.client.utils.UserContext.CORRELATION_IDENTIFIER;


public class UserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().add(CORRELATION_IDENTIFIER, UserContextHolder.getContext().getCorrelationId());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
