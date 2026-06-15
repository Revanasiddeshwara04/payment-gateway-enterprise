package com.paymentgateway.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "paymentgatewaysecretkeypaymentgatewaysecretkey";

    public String generateToken(String email) {

        SecretKey key =
                Keys.hmacShaKeyFor(
                        SECRET_KEY.getBytes(StandardCharsets.UTF_8)
                );

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 86400000
                        )
                )
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {

        SecretKey key =
                Keys.hmacShaKeyFor(
                        SECRET_KEY.getBytes(StandardCharsets.UTF_8)
                );

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public boolean validateToken(String token) {

        try {

            SecretKey key =
                    Keys.hmacShaKeyFor(
                            SECRET_KEY.getBytes(StandardCharsets.UTF_8)
                    );

            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception ex) {
            return false;
        }
    }
}