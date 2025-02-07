package com.pragma.powerup.infrastructure.output.jpa.repository;

import com.pragma.powerup.infrastructure.output.jpa.entity.TechnologyEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ITechnologyRepository extends ReactiveCrudRepository<TechnologyEntity, Long> {

    Mono<TechnologyEntity> findByName(String name);

    Flux<TechnologyEntity> findBy(Pageable pageable);

    @Query("SELECT * FROM technologies INNER JOIN capacity_technology ON technologies.id = capacity_technology.technology_id WHERE capacity_technology.capacity_id = :id")
    Flux<TechnologyEntity> findByCapacityId(Long id);
}