package com.pets.pet.web.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RefreshTokenResponse {
    private String accessToken;
    private String refreshToken;
}
