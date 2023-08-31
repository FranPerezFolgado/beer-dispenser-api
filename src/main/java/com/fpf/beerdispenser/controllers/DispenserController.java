package com.fpf.beerdispenser.controllers;


import com.fpf.beerdispenser.dto.request.ChangeDispenserStatusRequestDTO;
import com.fpf.beerdispenser.dto.request.CreateBeerDispenserRequestDTO;
import com.fpf.beerdispenser.dto.response.CreateBeerDispenserResponseDTO;
import com.fpf.beerdispenser.services.ChangeDispenserStatusService;
import com.fpf.beerdispenser.services.CreateBeerDispenserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/dispenser")
public class DispenserController {


    private final CreateBeerDispenserService createBeerDispenserService;

    private final ChangeDispenserStatusService changeDispenserStatusService;

    public DispenserController(CreateBeerDispenserService createBeerDispenserService, ChangeDispenserStatusService changeDispenserStatusService) {
        this.createBeerDispenserService = createBeerDispenserService;
        this.changeDispenserStatusService = changeDispenserStatusService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateBeerDispenserResponseDTO> createDispenser(@RequestBody CreateBeerDispenserRequestDTO requestDTO) {
        CreateBeerDispenserResponseDTO dispenserResponseDTO = createBeerDispenserService.createDispenser(requestDTO);
        return ResponseEntity.ok(dispenserResponseDTO);
    }

    @PutMapping(path = "/{dispenserId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeDispenserStatus(@PathVariable UUID dispenserId, @RequestBody ChangeDispenserStatusRequestDTO requestDTO) {
        changeDispenserStatusService.changeDispenserStatus(dispenserId, requestDTO);
        return ResponseEntity.ok().build();
    }
}
