package com.pets.pet.services;

import com.pets.pet.web.dtos.request.VaccineCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;

public interface IVaccinesService {
    BaseResponse createVaccine(VaccineCreateRequest request);
    BaseResponse getVaccineById(Long id);
    BaseResponse getAllVaccines();
    BaseResponse deleteVaccine(Long id);

}
