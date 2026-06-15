package com.paymentgateway.auth.controller;

import com.paymentgateway.auth.dto.RegisterRequest;
import com.paymentgateway.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.paymentgateway.auth.dto.LoginRequest;
import com.paymentgateway.auth.dto.LoginResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("/test")
    public String test() {
        return "TEST OK";
    }

    @GetMapping("/profile")
    public String profile() {

        return "Welcome Authenticated User";
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}