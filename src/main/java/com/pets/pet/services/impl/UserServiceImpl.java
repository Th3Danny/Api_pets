package com.pets.pet.services.impl;

import com.pets.pet.persistance.entities.User;
import com.pets.pet.persistance.repositories.IUserRepository;
import com.pets.pet.services.IUserService;
import com.pets.pet.web.dtos.request.CreateUserRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import com.pets.pet.web.exeptions.EmailAlreadyExistsException;
import com.pets.pet.web.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse createUser(CreateUserRequest request) {
        // Verificar si el email ya existe
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + request.getEmail());
        }

        // Crear nuevo usuario
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Guardar usuario
        User savedUser = userRepository.save(user);

        return BaseResponse.builder()
                .data(savedUser)
                .message("User created successfully")
                .success(true)
                .httpStatus(HttpStatus.CREATED)
                .build();
    }

    @Override
    public BaseResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("User not found with id: " + id).getClass()));

        return BaseResponse.builder()
                .data(user)
                .message("User retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
    public BaseResponse getAllUsers() {
        List<User> users = userRepository.findAll();

        return BaseResponse.builder()
                .data(users)
                .message("Users retrieved successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }


    @Override
    public BaseResponse deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("User not found with id: " + id).getClass()));

        userRepository.deleteById(id);

        return BaseResponse.builder()
                .data(null)
                .message("User deleted successfully")
                .success(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }

    @Override
        public BaseResponse getUserByEmail(String email) {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new ResourceNotFoundException(("User not found with email: " + email).getClass()));

            return BaseResponse.builder()
                    .data(user)
                    .message("User retrieved successfully")
                    .success(true)
                    .httpStatus(HttpStatus.OK)
                    .build();
        }

        // Método unificado que puede usarse para ambos casos
        @Override
        public Optional<User> getOptionalUserByEmail(String email) {
            return userRepository.findByEmail(email);
        }
}
