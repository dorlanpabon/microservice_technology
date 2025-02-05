package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyPersistencePort {

    Mono<Technology> saveTechnology(Technology technology);

    Mono<Technology> findTechnologyByName(String name);

    Flux<Technology> listTechnologies(Integer page, Integer size, String direction);
}