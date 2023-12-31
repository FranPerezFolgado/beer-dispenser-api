package com.fpf.beerdispenser.respositories;

import com.fpf.beerdispenser.entities.BeerDispenser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeerDispenserRepository extends JpaRepository<BeerDispenser, UUID> {
}
