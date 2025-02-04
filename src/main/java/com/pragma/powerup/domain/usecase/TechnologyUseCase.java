package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.ITechnologyServicePort;
import com.pragma.powerup.domain.model.Technology;
import com.pragma.powerup.domain.spi.ITechnologyPersistencePort;
import reactor.core.publisher.Mono;

public class TechnologyUseCase implements ITechnologyServicePort {

    private final ITechnologyPersistencePort objectPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort objectPersistencePort) {
        this.objectPersistencePort = objectPersistencePort;
    }

    @Override
    public Mono<Void> saveTechnology(Technology technology) {
        return objectPersistencePort.saveTechnology(technology).then();
    }

}