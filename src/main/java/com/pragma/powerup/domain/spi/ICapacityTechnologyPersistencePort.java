package com.pragma.powerup.domain.spi;

import com.pragma.powerup.domain.model.CapacityTechnology;
import com.pragma.powerup.domain.model.Technology;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICapacityTechnologyPersistencePort {

    Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies);

}