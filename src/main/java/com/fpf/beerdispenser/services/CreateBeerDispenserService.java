package com.fpf.beerdispenser.services;


import com.fpf.beerdispenser.dto.request.CreateBeerDispenserDTO;
import com.fpf.beerdispenser.dto.response.CreateDispenserResponseDTO;
import com.fpf.beerdispenser.entities.BeerDispenser;
import com.fpf.beerdispenser.respositories.BeerDispenserRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CreateBeerDispenserService {

    private final BeerDispenserRepository beerDispenserRepository;

    public CreateBeerDispenserService(BeerDispenserRepository beerDispenserRepository) {
        this.beerDispenserRepository = beerDispenserRepository;
    }


    public CreateDispenserResponseDTO createDispenser(@NonNull CreateBeerDispenserDTO createBeerDispenserDTO) {
        BeerDispenser dispenser = createBeerDispenserDTO.mapToEntity();
        dispenser = beerDispenserRepository.save(dispenser);
        return CreateDispenserResponseDTO.mapFromEntity(dispenser);
    }

}
