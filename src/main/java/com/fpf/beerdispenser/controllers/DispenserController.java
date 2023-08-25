package com.fpf.beerdispenser.controllers;


import com.fpf.beerdispenser.dto.request.CreateBeerDispenserRequestDTO;
import com.fpf.beerdispenser.dto.response.CreateBeerDispenserResponseDTO;
import com.fpf.beerdispenser.services.CreateBeerDispenserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dispenser")
public class DispenserController {


    private final CreateBeerDispenserService createBeerDispenserService;

    public DispenserController(CreateBeerDispenserService createBeerDispenserService) {
        this.createBeerDispenserService = createBeerDispenserService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateBeerDispenserResponseDTO> createDispenser(@RequestBody CreateBeerDispenserRequestDTO requestDTO) {
        CreateBeerDispenserResponseDTO dispenserResponseDTO = createBeerDispenserService.createDispenser(requestDTO);
        return ResponseEntity.ok(dispenserResponseDTO);
    }
}
