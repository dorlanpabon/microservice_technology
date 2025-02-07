package com.pragma.powerup.domain.spi;

import reactor.core.publisher.Mono;

import java.util.List;

public interface ICapacityTechnologyPersistencePort {

    Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies);

}