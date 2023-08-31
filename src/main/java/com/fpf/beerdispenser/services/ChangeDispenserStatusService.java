package com.fpf.beerdispenser.services;

import com.fpf.beerdispenser.dto.request.ChangeDispenserStatusRequestDTO;
import com.fpf.beerdispenser.entities.BeerDispenser;
import com.fpf.beerdispenser.entities.BeerDispenserUsage;
import com.fpf.beerdispenser.enums.BeerDispenserStatusEnum;
import com.fpf.beerdispenser.respositories.BeerDispenserRepository;
import com.fpf.beerdispenser.respositories.BeerDispenserUsageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ChangeDispenserStatusService {

    private final BeerDispenserRepository beerDispenserRepository;
    private final BeerDispenserUsageRepository beerDispenserUsageRepository;

    public ChangeDispenserStatusService(BeerDispenserRepository beerDispenserRepository, BeerDispenserUsageRepository beerDispenserUsageRepository) {
        this.beerDispenserRepository = beerDispenserRepository;
        this.beerDispenserUsageRepository = beerDispenserUsageRepository;
    }

    public void changeDispenserStatus(final UUID dispenserId, final ChangeDispenserStatusRequestDTO changeDispenserStatusRequestDTO) {
        BeerDispenser beerDispenser = getBeerDispenserById(dispenserId);

        if (changeDispenserStatusRequestDTO.status() == BeerDispenserStatusEnum.OPEN) {
            createNewUsage(beerDispenser, changeDispenserStatusRequestDTO);
        } else {
            closeLastUsage(beerDispenser, changeDispenserStatusRequestDTO);
        }

        updateBeerDispenserProperties(beerDispenser, changeDispenserStatusRequestDTO);
    }

    private BeerDispenser getBeerDispenserById(UUID dispenserId) {
        Optional<BeerDispenser> beerDispenserOpt = beerDispenserRepository.findById(dispenserId);
        return beerDispenserOpt.orElseThrow(() -> new EntityNotFoundException(String.format("Id %s not found", dispenserId)));
    }

    private void createNewUsage(BeerDispenser beerDispenser, ChangeDispenserStatusRequestDTO changeDispenserStatusRequestDTO) {
        BeerDispenserUsage usage = BeerDispenserUsage.builder()
                .beerDispenser(beerDispenser)
                .openedAt(changeDispenserStatusRequestDTO.updatedAt())
                .flowVolume(beerDispenser.getFlowVolume())
                .build();

        beerDispenserUsageRepository.save(usage);
    }

    private void closeLastUsage(BeerDispenser beerDispenser, ChangeDispenserStatusRequestDTO changeDispenserStatusRequestDTO) {
        BeerDispenserUsage usage = beerDispenser.getUsages().get(beerDispenser.getUsages().size() - 1);
        usage.setClosedAt(changeDispenserStatusRequestDTO.updatedAt());
        beerDispenserUsageRepository.save(usage);
    }

    private void updateBeerDispenserProperties(BeerDispenser beerDispenser, ChangeDispenserStatusRequestDTO changeDispenserStatusRequestDTO) {
        changeDispenserStatusRequestDTO.mapToEntity(beerDispenser);
        beerDispenserRepository.save(beerDispenser);
    }
}
