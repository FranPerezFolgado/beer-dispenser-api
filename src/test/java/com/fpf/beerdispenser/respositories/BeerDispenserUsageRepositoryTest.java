package com.fpf.beerdispenser.respositories;

import com.fpf.beerdispenser.entities.BeerDispenser;
import com.fpf.beerdispenser.entities.BeerDispenserUsage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class BeerDispenserUsageRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    private BeerDispenserUsageRepository beerDispenserUsageRepository;

    @Test
    void saveTest() {
        BeerDispenser dispenser = BeerDispenser.builder().flowVolume(1.1).build();
        entityManager.persist(dispenser);

        Double flowVolume = 1D;
        BeerDispenserUsage usage = BeerDispenserUsage.builder()
                .flowVolume(flowVolume)
                .beerDispenser(dispenser)
                .build();
        BeerDispenserUsage saved = beerDispenserUsageRepository.save(usage);
        assertNotNull(saved.getUsageId());
        assertEquals(flowVolume, saved.getFlowVolume());

    }
}