package br.sp.gov.etec.job_description.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String redirectUrl = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("USER")) {
                redirectUrl = "/AkvPlus";
                break;
            } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
                redirectUrl = "/home";
                break;
            }
        }
        System.out.println("redirectUrl " + redirectUrl);
        if (redirectUrl.equals("")) {
            throw new IllegalStateException();
        }
        new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }
}