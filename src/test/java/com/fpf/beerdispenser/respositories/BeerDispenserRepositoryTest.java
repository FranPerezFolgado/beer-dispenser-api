package com.fpf.beerdispenser.respositories;

import com.fpf.beerdispenser.entities.BeerDispenser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class BeerDispenserRepositoryTest {

    @Autowired
    private BeerDispenserRepository beerDispenserRepository;




    @Test
    void saveTest(){
        Double flowVolume = 1D;
        BeerDispenser dispenser = BeerDispenser.builder().flowVolume(flowVolume).build();
        BeerDispenser saved = beerDispenserRepository.save(dispenser);
        assertNotNull(saved.getId());
        assertEquals(flowVolume,saved.getFlowVolume());

    }
}