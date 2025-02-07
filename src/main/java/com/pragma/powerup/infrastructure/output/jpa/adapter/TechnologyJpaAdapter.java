package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.domain.model.Technology;
import com.pragma.powerup.domain.spi.ITechnologyPersistencePort;
import com.pragma.powerup.infrastructure.output.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
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

    @Override
    public Flux<Technology> listTechnologies(Integer page, Integer size, String direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");

        return technologyRepository.findBy(pageable)
                        .map(technologyEntityMapper::toTechnology);
    }

    @Override
    public Flux<Technology> findTechnologiesByCapacity(Long id) {
        return technologyRepository.findByCapacityId(id)
                .map(technologyEntityMapper::toTechnology);
    }
}