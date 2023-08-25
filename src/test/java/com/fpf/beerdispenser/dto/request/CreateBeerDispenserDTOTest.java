package com.fpf.beerdispenser.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fpf.beerdispenser.entities.BeerDispenser;
import org.junit.jupiter.api.Test;

class CreateBeerDispenserDTOTest {
    /**
     * Method under test: {@link CreateBeerDispenserDTO#mapToEntity()}
     */
    @Test
    void testMapToEntity() {
        BeerDispenser actualMapToEntityResult = (new CreateBeerDispenserDTO(10.0d)).mapToEntity();
        assertEquals(10.0d, actualMapToEntityResult.getFlowVolume().doubleValue());
        assertNull(actualMapToEntityResult.getUsages());
        assertNull(actualMapToEntityResult.getUpdatedAt());
        assertNull(actualMapToEntityResult.getStatus());
        assertNull(actualMapToEntityResult.getId());
    }
}

