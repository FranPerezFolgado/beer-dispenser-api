package com.fpf.beerdispenser.respositories;

import com.fpf.beerdispenser.entities.BeerDispenser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerDispenserRepository extends JpaRepository<BeerDispenser, UUID> {
}
