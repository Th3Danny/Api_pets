package com.pets.pet.services;

import com.pets.pet.web.dtos.request.PetCreateRequest;
import com.pets.pet.web.dtos.request.PetUpdateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;

    public interface IPetsService {
        BaseResponse createPet(PetCreateRequest request);
        BaseResponse getPetById(Long id);
        BaseResponse getAllPets();
        BaseResponse getPetsByUserId(Long userId);
        BaseResponse updatePet(Long id, PetUpdateRequest request);
        BaseResponse getPetsBySpecies(String species);
        BaseResponse deletePet(Long id);
    }

