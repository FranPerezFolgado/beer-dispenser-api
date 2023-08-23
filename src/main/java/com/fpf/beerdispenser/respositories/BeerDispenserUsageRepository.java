package com.fpf.beerdispenser.respositories;

import com.fpf.beerdispenser.entities.BeerDispenserUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerDispenserUsageRepository extends JpaRepository<BeerDispenserUsage, Long> {

}
