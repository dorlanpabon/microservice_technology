package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.ITechnologyServicePort;
import com.pragma.powerup.domain.constants.DomainConstants;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.Technology;
import com.pragma.powerup.domain.spi.ITechnologyPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class TechnologyUseCase implements ITechnologyServicePort {

    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public Mono<Void> saveTechnology(Technology technology) {
        return Mono.just(technology)
                .flatMap(tech -> {
                    if (tech.getName() == null || tech.getName().length() > 50) {
                        return Mono.error(new DomainException(DomainConstants.NAME_MUST_BE_LESS_THAN_50_CHARACTERS));
                    }
                    if (tech.getDescription() == null || tech.getDescription().length() > 90) {
                        return Mono.error(new DomainException(DomainConstants.DESCRIPTION_MUST_BE_LESS_THAN_90_CHARACTERS));
                    }
                    return technologyPersistencePort.findTechnologyByName(tech.getName());
                })
                .flatMap(tech -> Mono.error(new DomainException(DomainConstants.TECHNOLOGY_ALREADY_EXISTS)))
                .switchIfEmpty(Mono.defer(() -> technologyPersistencePort.saveTechnology(technology)))
                .then();
    }

    @Override
    public Flux<Technology> listTechnologies(Integer page, Integer size, String direction) {
        return technologyPersistencePort.listTechnologies(page, size, direction);
    }

}