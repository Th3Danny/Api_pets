package com.pets.pet.web.controllers;

import com.pets.pet.services.IAuthService;
import com.pets.pet.web.dtos.request.AuthenticateRequest;
import com.pets.pet.web.dtos.request.RefreshTokenRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("authenticate")
    public ResponseEntity<BaseResponse> authenticate(@Valid @RequestBody AuthenticateRequest request) {
        BaseResponse baseResponse = authService.authenticate(request);

        return baseResponse.buildResponseEntity();
    }

    @PostMapping("refresh-token")
    public ResponseEntity<BaseResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        BaseResponse baseResponse = authService.refreshToken(request);

        return baseResponse.buildResponseEntity();
    }
}
