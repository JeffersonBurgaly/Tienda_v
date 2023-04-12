package com.tienda;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
    protected void handle(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
    }
}
