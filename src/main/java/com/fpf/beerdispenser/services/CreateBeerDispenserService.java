package com.fpf.beerdispenser.services;


import com.fpf.beerdispenser.dto.request.CreateBeerDispenserRequestDTO;
import com.fpf.beerdispenser.dto.response.CreateBeerDispenserResponseDTO;
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


    public CreateBeerDispenserResponseDTO createDispenser(@NonNull CreateBeerDispenserRequestDTO createBeerDispenserRequestDTO) {
        BeerDispenser dispenser = createBeerDispenserRequestDTO.mapToEntity();
        dispenser = beerDispenserRepository.save(dispenser);
        return CreateBeerDispenserResponseDTO.mapFromEntity(dispenser);
    }

}
