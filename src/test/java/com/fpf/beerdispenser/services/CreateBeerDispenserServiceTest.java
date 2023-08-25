package com.fpf.beerdispenser.services;

import com.fpf.beerdispenser.dto.request.CreateBeerDispenserDTO;
import com.fpf.beerdispenser.entities.BeerDispenser;
import com.fpf.beerdispenser.respositories.BeerDispenserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {CreateBeerDispenserService.class})
@ExtendWith(SpringExtension.class)
class CreateBeerDispenserServiceTest {
    @MockBean
    private BeerDispenserRepository beerDispenserRepository;

    @Autowired
    private CreateBeerDispenserService createBeerDispenserService;

    /**
     * Method under test: {@link CreateBeerDispenserService#createDispenser(CreateBeerDispenserDTO)}
     */
    @Test
    void testCreateDispenser() {
        BeerDispenser beerDispenser = new BeerDispenser();
        beerDispenser.setFlowVolume(10.0d);
        beerDispenser.setId(UUID.randomUUID());
        beerDispenser.setStatus("Status");
        beerDispenser.setUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());
        beerDispenser.setUsages(new ArrayList<>());
        when(beerDispenserRepository.save(Mockito.any())).thenReturn(beerDispenser);
        assertEquals(10.0d,
                createBeerDispenserService.createDispenser(new CreateBeerDispenserDTO(10.0d)).flowVolume().doubleValue());
        verify(beerDispenserRepository).save(Mockito.any());
    }
}

