package com.fpf.beerdispenser.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpf.beerdispenser.entities.BeerDispenser;
import lombok.Builder;

@Builder
public record CreateBeerDispenserRequestDTO(
        @JsonProperty("flow_volume")
        Double flowVolume
) {


    public BeerDispenser mapToEntity() {
        return BeerDispenser.builder()
                .flowVolume(this.flowVolume)
                .build();
    }

}
