package org.tb.jgoauth.controllers;

import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Map;

@Controller
public class OAuthCallbackController {
    @Value("${google.client-id}")
    private String clientId;

    @Value("${google.client-secret}")
    private String clientSecret;

    @Value("${google.redirect-uri}")
    private String redirectUri;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/oauth2/callback")
    public String callback(@RequestParam("code") String code, Model model) {

        // 1. Exchange authorization code for tokens
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(params, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(
                        "https://oauth2.googleapis.com/token",
                        request,
                        Map.class
                );

        String idToken = (String) response.getBody().get("id_token");

        // 2. Decode ID token (for demo ONLY)
        String email = extractEmailFromIdToken(idToken);

        // Print email on backend
        System.out.println("Logged in user email: " + email);

        // Send to UI
        model.addAttribute("email", email);
        return "welcome";
    }

    // ⚠️ Simplified decoding (do NOT skip verification in real apps)
    private String extractEmailFromIdToken(String idToken) {
        String[] parts = idToken.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(parts[1]));
        return JsonPath.read(payload, "$.email");
    }
}
