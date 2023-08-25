package com.fpf.beerdispenser.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpf.beerdispenser.entities.BeerDispenser;
import lombok.Builder;

@Builder
public record CreateBeerDispenserResponseDTO
        (
                String id,
                @JsonProperty("flow_volume")
                Double flowVolume
        ) {

    public static CreateBeerDispenserResponseDTO mapFromEntity(BeerDispenser beerDispenser) {
        return CreateBeerDispenserResponseDTO.builder()
                .id(String.valueOf(beerDispenser.getId()))
                .flowVolume(beerDispenser.getFlowVolume())
                .build();
    }
}
