package com.pragma.powerup.infrastructure.output.jpa.repository;

import com.pragma.powerup.domain.model.CapacityTechnology;
import com.pragma.powerup.infrastructure.output.jpa.entity.CapacityTechnologyEntity;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface ICapacityTechnologyRepository extends ReactiveCrudRepository<CapacityTechnologyEntity, Long> {

    Flux<CapacityTechnologyEntity> findBy(Pageable pageable);

}