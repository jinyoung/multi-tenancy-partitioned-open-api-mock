package com.example.demo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//import newtest.security.AuthenticationService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
class TenantFilter implements Filter {

    @Autowired
    TenantIdentifierResolver tenantIdentifierResolver;

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {

        String tenant = ((HttpServletRequest) request).getHeader("tenantId");

        tenantIdentifierResolver.setCurrentTenant(tenant);

        try {
            chain.doFilter(request, response);
        } finally {
            tenantIdentifierResolver.setCurrentTenant("");
        }
    }
}
