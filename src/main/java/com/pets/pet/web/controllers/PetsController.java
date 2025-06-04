package com.pets.pet.web.controllers;

import com.pets.pet.services.IPetsService;
import com.pets.pet.web.dtos.request.PetCreateRequest;
import com.pets.pet.web.dtos.request.PetUpdateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetsController {
    private final IPetsService petsService;

    public PetsController(IPetsService petsService) {
        this.petsService = petsService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> createPet(@Valid @RequestBody PetCreateRequest request) {
        BaseResponse baseResponse = petsService.createPet(request);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> getPetById(@PathVariable Long id) {
        BaseResponse baseResponse = petsService.getPetById(id);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getAllPets() {
        BaseResponse baseResponse = petsService.getAllPets();
        return baseResponse.buildResponseEntity();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<BaseResponse> getPetsByUserId(@PathVariable Long userId) {
        BaseResponse baseResponse = petsService.getPetsByUserId(userId);
        return baseResponse.buildResponseEntity();
    }

    @GetMapping("/species/{species}")
    public ResponseEntity<BaseResponse> getPetsBySpecies(@PathVariable String species) {
        BaseResponse baseResponse = petsService.getPetsBySpecies(species);
        return baseResponse.buildResponseEntity();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse> updatePet(
            @PathVariable Long id,
            @Valid @RequestBody PetUpdateRequest request) {
        BaseResponse baseResponse = petsService.updatePet(id, request);
        return baseResponse.buildResponseEntity();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deletePet(@PathVariable Long id) {
        BaseResponse baseResponse = petsService.deletePet(id);
        return baseResponse.buildResponseEntity();
    }
}