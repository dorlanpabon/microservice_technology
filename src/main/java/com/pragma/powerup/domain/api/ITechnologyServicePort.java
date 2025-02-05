package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyServicePort {

    Mono<Void> saveTechnology(Technology technology);

    Flux<Technology> listTechnologies(Integer page, Integer size, String direction);
}