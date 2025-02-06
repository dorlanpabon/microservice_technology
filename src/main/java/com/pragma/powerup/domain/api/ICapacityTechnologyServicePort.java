package com.pragma.powerup.domain.api;

import com.pragma.powerup.domain.model.Technology;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICapacityTechnologyServicePort {

    Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies);

}