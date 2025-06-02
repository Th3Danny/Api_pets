package com.pets.pet.services;
import com.pets.pet.persistance.entities.User;
import com.pets.pet.web.dtos.request.CreateUserRequest;
import com.pets.pet.web.dtos.response.BaseResponse;

import java.util.Optional;

public interface IUserService {
    BaseResponse createUser(CreateUserRequest request);
    BaseResponse getUserById(Long id);
    BaseResponse getAllUsers();
    BaseResponse deleteUser(Long id);
    BaseResponse getUserByEmail(String email);
    Optional<User> getOptionalUserByEmail(String email);
}
