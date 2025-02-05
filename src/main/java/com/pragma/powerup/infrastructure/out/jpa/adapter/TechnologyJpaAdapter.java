package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Technology;
import com.pragma.powerup.domain.spi.ITechnologyPersistencePort;
import com.pragma.powerup.infrastructure.out.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class TechnologyJpaAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public Mono<Technology> saveTechnology(Technology technology) {
        return Mono.just(technologyEntityMapper.toEntity(technology))
                .flatMap(technologyRepository::save)
                .map(technologyEntityMapper::toTechnology);
    }

    @Override
    public Mono<Technology> findTechnologyByName(String name) {
        return technologyRepository.findByName(name)
                .map(technologyEntityMapper::toTechnology);
    }
}