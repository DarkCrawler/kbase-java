package org.tb.kbase.jgoauth.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/*
Controller called to google for user -> google interation
* user needs to validate username and password
 */

@RestController
public class GoogleLoginController {
    @Value("${google.client-id}")
    private String clientId;

    @Value("${google.redirect-uri}")
    private String redirectUri;

    @GetMapping("/login/google")
    /*
        AUTH REQUEST
        SEND FROM FRONT END TO G-eOAUTH
     */
    public void googleLogin(HttpServletResponse response) throws IOException {

        String scope = "openid email profile";
        String authUrl =
                "https://accounts.google.com/o/oauth2/v2/auth"
                        + "?client_id=" + clientId
                        + "&response_type=code"
                        + "&scope=" + URLEncoder.encode(scope, StandardCharsets.UTF_8)
                        + "&redirect_uri=" + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8)
                        + "&access_type=offline"
                        + "&prompt=consent";

        response.sendRedirect(authUrl);
    }
}
