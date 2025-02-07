package com.pragma.powerup.infrastructure.adapters.jpa.adapter;

import com.pragma.powerup.domain.spi.ICapacityTechnologyPersistencePort;
import com.pragma.powerup.infrastructure.adapters.jpa.mapper.ICapacityTechnologyEntityMapper;
import com.pragma.powerup.infrastructure.adapters.jpa.repository.ICapacityTechnologyRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class CapacityTechnologyJpaAdapter implements ICapacityTechnologyPersistencePort {

    private final ICapacityTechnologyRepository capacityTechnologyRepository;
    private final ICapacityTechnologyEntityMapper capacityTechnologyEntityMapper;

    @Override
    public Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies) {
        return Flux.fromIterable(technologies)
                .map(technologyId -> capacityTechnologyEntityMapper.toEntity(capacityId, technologyId))
                .flatMap(capacityTechnologyRepository::save)
                .then();
    }

}
