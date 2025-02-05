package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Technology;
import reactor.core.publisher.Mono;

public interface ITechnologyPersistencePort {

    Mono<Technology> saveTechnology(Technology technology);

    Mono<Technology> findTechnologyByName(String name);
}