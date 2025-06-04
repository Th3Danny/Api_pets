package com.pets.pet.services.impl;

import com.pets.pet.persistance.entities.User;
import com.pets.pet.services.IAuthService;
import com.pets.pet.services.IUserService;
import com.pets.pet.types.JWTType;
import com.pets.pet.utils.IJWTUtils;
import com.pets.pet.web.dtos.request.AuthenticateRequest;
import com.pets.pet.web.dtos.request.RefreshTokenRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import com.pets.pet.web.exeptions.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AuthServiceImpl implements IAuthService {

    private final IUserService userService;
    private final IJWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthServiceImpl(IUserService userService, IJWTUtils jwtUtils) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public BaseResponse authenticate(AuthenticateRequest request) {
        // Obtener usuario por email
        User user = userService.getOptionalUserByEmail(request.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        // Validar contraseña
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        // Crear claims
        Map<String, Object> claims = Map.of(
                "id", user.getId(),
                "email", user.getEmail()
        );

        // Generar tokens
        String accessToken = jwtUtils.generateToken(user.getEmail(), claims, JWTType.ACCESS_TOKEN);
        String refreshToken = jwtUtils.generateToken(user.getEmail(), null, JWTType.REFRESH_TOKEN);
        Long idUser = user.getId();

        // Armar respuesta
        Map<String, Object> tokens = Map.ofEntries(
                Map.entry("access_token", accessToken),
                Map.entry("refresh_token", refreshToken),
                Map.entry("id_user",idUser)
        );

        return BaseResponse.builder()
                .data(tokens)
                .message("Authenticated successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }


    @Override
    public BaseResponse refreshToken(RefreshTokenRequest request) {
        // Validar token
        Boolean isTokenValid = jwtUtils.isTokenValid(request.getRefreshToken(), JWTType.REFRESH_TOKEN);

        if (!isTokenValid) {
            throw new InvalidCredentialsException();
        }

        // Obtener info del token
        String email = jwtUtils.getSubjectFromToken(request.getRefreshToken(), JWTType.REFRESH_TOKEN);
        Map<String, Object> claims = jwtUtils.getClaimsFromToken(request.getRefreshToken(), JWTType.REFRESH_TOKEN);

        // Generar nuevos tokens
        String accessToken = jwtUtils.generateToken(email, claims, JWTType.ACCESS_TOKEN);
        String refreshToken = jwtUtils.generateToken(email, null, JWTType.REFRESH_TOKEN);

        Map<String, Object> tokens = Map.of(
                "access_token", accessToken,
                "refresh_token", refreshToken
        );


        return BaseResponse.builder()
                .data(tokens)
                .message("Token refreshed")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

}

