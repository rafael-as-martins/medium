package com.medium.client.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.medium.client.utils.UserContext.CORRELATION_IDENTIFIER;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        UserContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(CORRELATION_IDENTIFIER));

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
