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

        if (capacityId == null) {
            return Mono.error(new DomainException(DomainConstants.INVALID_CAPACITY_ID));
        }

        if (technologies == null || technologies.isEmpty()) {
            return Mono.error(new DomainException(DomainConstants.EMPTY_TECHNOLOGY_LIST));
        }

        int techSize = technologies.size();
        if (techSize < DomainConstants.MIN_TECHNOLOGIES || techSize > DomainConstants.MAX_TECHNOLOGIES) {
            return Mono.error(new DomainException(DomainConstants.INVALID_TECHNOLOGY_COUNT));
        }

        return capacityTechnologyPersistencePort.saveTechnologiesCapacity(capacityId, technologies);
    }
}
