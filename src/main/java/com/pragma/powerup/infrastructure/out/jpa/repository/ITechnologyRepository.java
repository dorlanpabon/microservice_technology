package com.pragma.powerup.infrastructure.out.jpa.repository;

import com.pragma.powerup.infrastructure.out.jpa.entity.ObjectEntity;
import com.pragma.powerup.infrastructure.out.jpa.entity.TechnologyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ITechnologyRepository extends ReactiveCrudRepository<TechnologyEntity, Long> {

}