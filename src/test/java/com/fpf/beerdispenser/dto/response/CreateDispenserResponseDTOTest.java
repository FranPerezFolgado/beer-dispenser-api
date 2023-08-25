package com.fpf.beerdispenser.dto.response;

import com.fpf.beerdispenser.entities.BeerDispenser;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateDispenserResponseDTOTest {
    /**
     * Method under test: {@link CreateDispenserResponseDTO#mapFromEntity(BeerDispenser)}
     */
    @Test
    void testMapFromEntity() {
        BeerDispenser beerDispenser = new BeerDispenser();
        beerDispenser.setFlowVolume(10.0d);
        beerDispenser.setId(UUID.randomUUID());
        beerDispenser.setStatus("Status");
        beerDispenser.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        beerDispenser.setUsages(new ArrayList<>());
        CreateDispenserResponseDTO dispenserResponseDTO = CreateDispenserResponseDTO.mapFromEntity(beerDispenser);
        assertEquals(beerDispenser.getFlowVolume(), dispenserResponseDTO.flowVolume());
        assertEquals(beerDispenser.getId().toString(), dispenserResponseDTO.id());
    }
}

