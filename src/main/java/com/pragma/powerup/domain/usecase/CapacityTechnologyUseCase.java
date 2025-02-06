package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.ICapacityTechnologyServicePort;
import com.pragma.powerup.domain.constants.DomainConstants;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.spi.ICapacityTechnologyPersistencePort;
import reactor.core.publisher.Mono;

import java.util.List;

public class CapacityTechnologyUseCase implements ICapacityTechnologyServicePort {

    private final ICapacityTechnologyPersistencePort capacityTechnologyPersistencePort;

    public CapacityTechnologyUseCase(ICapacityTechnologyPersistencePort capacityTechnologyPersistencePort) {
        this.capacityTechnologyPersistencePort = capacityTechnologyPersistencePort;
    }

    @Override
    public Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies) {
        return Mono.justOrEmpty(capacityId)
                .switchIfEmpty(Mono.error(new DomainException(DomainConstants.INVALID_CAPACITY_ID)))
                .then(Mono.justOrEmpty(technologies))
                .filter(list -> !list.isEmpty())
                .switchIfEmpty(Mono.error(new DomainException(DomainConstants.EMPTY_TECHNOLOGY_LIST)))
                .filter(list -> list.size() >= DomainConstants.MIN_TECHNOLOGIES && list.size() <= DomainConstants.MAX_TECHNOLOGIES)
                .switchIfEmpty(Mono.error(new DomainException(DomainConstants.INVALID_TECHNOLOGY_COUNT)))
                .flatMap(validList -> capacityTechnologyPersistencePort.saveTechnologiesCapacity(capacityId, validList));
    }
}
