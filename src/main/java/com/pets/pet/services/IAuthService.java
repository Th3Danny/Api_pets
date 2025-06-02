package com.pets.pet.services;

import com.pets.pet.web.dtos.request.AuthenticateRequest;
import com.pets.pet.web.dtos.request.RefreshTokenRequest;
import com.pets.pet.web.dtos.response.BaseResponse;

public interface IAuthService {
    BaseResponse authenticate (AuthenticateRequest request);
    BaseResponse refreshToken (RefreshTokenRequest request);
}
