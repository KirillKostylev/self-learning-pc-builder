package com.pet.project.pcbuilder.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record GpuRequest(
        @NotBlank String name,
        @Positive int memorySize,
        @Positive double clockSpeed
) {

}
