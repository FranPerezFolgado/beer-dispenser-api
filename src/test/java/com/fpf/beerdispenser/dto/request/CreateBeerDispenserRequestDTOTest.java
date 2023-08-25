package com.fpf.beerdispenser.dto.request;

import com.fpf.beerdispenser.entities.BeerDispenser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CreateBeerDispenserRequestDTOTest {
    /**
     * Method under test: {@link CreateBeerDispenserRequestDTO#mapToEntity()}
     */
    @Test
    void testMapToEntity() {
        BeerDispenser actualMapToEntityResult = (new CreateBeerDispenserRequestDTO(10.0d)).mapToEntity();
        assertEquals(10.0d, actualMapToEntityResult.getFlowVolume().doubleValue());
        assertNull(actualMapToEntityResult.getUsages());
        assertNull(actualMapToEntityResult.getUpdatedAt());
        assertNull(actualMapToEntityResult.getStatus());
        assertNull(actualMapToEntityResult.getId());
    }
}

