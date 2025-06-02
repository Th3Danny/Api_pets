package com.pets.pet.services;

import com.pets.pet.web.dtos.request.DietCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;

public interface IDietService {
    BaseResponse createDiet(DietCreateRequest request);
    BaseResponse getDietById(Long id);
    BaseResponse getAllDiets();
    BaseResponse deleteDiet(Long id);
}
