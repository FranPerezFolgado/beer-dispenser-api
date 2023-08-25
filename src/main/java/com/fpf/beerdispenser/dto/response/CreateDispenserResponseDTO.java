package com.fpf.beerdispenser.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpf.beerdispenser.entities.BeerDispenser;
import lombok.Builder;

@Builder
public record CreateDispenserResponseDTO
        (
                String id,
                @JsonProperty("flow_volume")
                Double flowVolume
        ){

    public static CreateDispenserResponseDTO mapFromEntity(BeerDispenser beerDispenser){
        return CreateDispenserResponseDTO.builder()
                .id(String.valueOf(beerDispenser.getId()))
                .flowVolume(beerDispenser.getFlowVolume())
                .build();
    }
}
