package com.fpf.beerdispenser.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fpf.beerdispenser.entities.BeerDispenser;
import com.fpf.beerdispenser.enums.BeerDispenserStatusEnum;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ChangeDispenserStatusRequestDTO(
        UUID id,

        BeerDispenserStatusEnum status,
        @JsonProperty("updated_at")
        LocalDateTime updatedAt
) {

    public BeerDispenser mapToEntity(BeerDispenser beerDispenser) {
        beerDispenser.setStatus(this.status);
        beerDispenser.setUpdatedAt(this.updatedAt);
        return beerDispenser;
    }


}
