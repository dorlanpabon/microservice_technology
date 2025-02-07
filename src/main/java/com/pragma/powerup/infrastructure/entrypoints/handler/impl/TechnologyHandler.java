package com.pragma.powerup.infrastructure.entrypoints.handler.impl;

import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyPageRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.response.TechnologyResponseDto;
import com.pragma.powerup.infrastructure.entrypoints.handler.ITechnologyHandler;
import com.pragma.powerup.infrastructure.entrypoints.mapper.ITechnologyRequestMapper;
import com.pragma.powerup.infrastructure.entrypoints.mapper.ITechnologyResponseMapper;
import com.pragma.powerup.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Transactional
public class TechnologyHandler implements ITechnologyHandler {

    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @Override
    public Mono<Void> saveTechnology(TechnologyRequestDto technologyRequestDto) {
        return Mono.just(technologyRequestDto)
                .map(technologyRequestMapper::toTechnology)
                .flatMap(technologyServicePort::saveTechnology)
                .then();
    }

    @Override
    public Flux<TechnologyResponseDto> listTechnologies(TechnologyPageRequestDto technologyPageRequestDto) {
        return technologyServicePort.listTechnologies(technologyPageRequestDto.getPage(), technologyPageRequestDto.getSize(), technologyPageRequestDto.getDirection())
                .map(technologyResponseMapper::toTechnologyResponseDto);
    }

    @Override
    public Flux<TechnologyResponseDto> findTechnologiesByCapacity(Long id) {
        return technologyServicePort.findTechnologiesByCapacity(id)
                .map(technologyResponseMapper::toTechnologyResponseDto);
    }

}