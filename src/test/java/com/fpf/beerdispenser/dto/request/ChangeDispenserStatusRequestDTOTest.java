package com.fpf.beerdispenser.dto.request;

import com.fpf.beerdispenser.entities.BeerDispenser;
import com.fpf.beerdispenser.enums.BeerDispenserStatusEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangeDispenserStatusRequestDTOTest {


    @Test
    void mapToEntityTest() {
        LocalDateTime date = LocalDateTime.now();
        ChangeDispenserStatusRequestDTO dto = ChangeDispenserStatusRequestDTO.builder()
                .status(BeerDispenserStatusEnum.CLOSE)
                .updatedAt(date)
                .build();

        BeerDispenser beerDispenser = dto.mapToEntity(new BeerDispenser());
        assertEquals(dto.status(), beerDispenser.getStatus());
        assertEquals(dto.updatedAt(), beerDispenser.getUpdatedAt());
    }
}