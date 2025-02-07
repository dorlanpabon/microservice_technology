package com.pragma.powerup.infrastructure.entrypoints.handler;

import reactor.core.publisher.Mono;

import java.util.List;

public interface ICapacityTechnologyHandler {

    Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies);

}