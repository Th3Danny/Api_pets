package com.pets.pet.services;

import com.pets.pet.web.dtos.request.MedicationCreateRequest;
import com.pets.pet.web.dtos.response.BaseResponse;

public interface IMedicationsService {
    BaseResponse createMedication(MedicationCreateRequest request);
    BaseResponse getMedicationById(Long id);
    BaseResponse getAllMedications();
    BaseResponse deleteMedication(Long id);

}
