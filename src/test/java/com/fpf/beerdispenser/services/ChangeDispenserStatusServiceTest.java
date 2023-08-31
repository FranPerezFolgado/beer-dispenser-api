package com.fpf.beerdispenser.services;

import com.fpf.beerdispenser.dto.request.ChangeDispenserStatusRequestDTO;
import com.fpf.beerdispenser.entities.BeerDispenser;
import com.fpf.beerdispenser.entities.BeerDispenserUsage;
import com.fpf.beerdispenser.enums.BeerDispenserStatusEnum;
import com.fpf.beerdispenser.respositories.BeerDispenserRepository;
import com.fpf.beerdispenser.respositories.BeerDispenserUsageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ContextConfiguration(classes = {ChangeDispenserStatusService.class})
@ExtendWith(MockitoExtension.class)
class ChangeDispenserStatusServiceTest {

    @InjectMocks
    private ChangeDispenserStatusService changeDispenserStatusService;

    @Mock
    private BeerDispenserUsageRepository beerDispenserUsageRepository;

    @Mock
    private BeerDispenserRepository beerDispenserRepository;

    /**
     * cases:
     * 1 if the requested status is OPEN
     * - create new usage
     * - map to entity
     * 2 if the requested status is CLOSE
     * - update last usage
     * - map to entity
     * <p>
     * Always assert mapping and saving entities (Beer dispenser and Usage)
     */
    @Test
    void changeDispenserStatusTest_createsNewUsage() {
        UUID uuid = UUID.randomUUID();
        ChangeDispenserStatusRequestDTO requestDTO = ChangeDispenserStatusRequestDTO.builder()
                .status(BeerDispenserStatusEnum.OPEN)
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDispenser beerDispenser = BeerDispenser.builder()
                .id(uuid)
                .flowVolume(0.2)
                .build();

        doReturn(Optional.of(beerDispenser)).when(beerDispenserRepository).findById(uuid);
        changeDispenserStatusService.changeDispenserStatus(uuid, requestDTO);

        verify(beerDispenserUsageRepository, times(1)).save(argThat((BeerDispenserUsage beerDispenserUsage) -> null == beerDispenserUsage.getUsageId()));
        verify(beerDispenserRepository, times(1)).save(any());
    }


    @Test
    void changeDispenserStatusTest_updatesUsage() {

        UUID uuid = UUID.randomUUID();
        ChangeDispenserStatusRequestDTO requestDTO = ChangeDispenserStatusRequestDTO.builder()
                .status(BeerDispenserStatusEnum.CLOSE)
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDispenserUsage usage = BeerDispenserUsage.builder()
                .usageId(112L)
                .build();

        BeerDispenser beerDispenser = BeerDispenser.builder()
                .id(uuid)
                .flowVolume(0.2)
                .usages(Collections.singletonList(usage))
                .build();

        doReturn(Optional.of(beerDispenser)).when(beerDispenserRepository).findById(uuid);
        doReturn(null).when(beerDispenserUsageRepository).save(any());
        changeDispenserStatusService.changeDispenserStatus(uuid, requestDTO);

//        verify(beerDispenserUsageRepository).save(any());
        verify(beerDispenserUsageRepository, times(1)).save(argThat((BeerDispenserUsage beerDispenserUsage) -> null != beerDispenserUsage.getUsageId()));
        verify(beerDispenserRepository, times(1)).save(any());

    }

}