package com.pragma.powerup.domain.api;

import reactor.core.publisher.Mono;

import java.util.List;

public interface ICapacityTechnologyServicePort {

    Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies);

}