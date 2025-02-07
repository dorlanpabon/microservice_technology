package com.pragma.powerup.infrastructure.adapters.jpa.repository;

import com.pragma.powerup.infrastructure.adapters.jpa.entity.CapacityTechnologyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ICapacityTechnologyRepository extends ReactiveCrudRepository<CapacityTechnologyEntity, Long> {

}