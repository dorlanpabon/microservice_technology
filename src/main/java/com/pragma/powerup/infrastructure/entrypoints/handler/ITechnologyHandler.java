package com.pragma.powerup.infrastructure.entrypoints.handler;

import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyPageRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.response.TechnologyResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyHandler {

    Mono<Void> saveTechnology(TechnologyRequestDto technologyRequestDto);

    Flux<TechnologyResponseDto> listTechnologies(TechnologyPageRequestDto technologyPageRequestDto);

    Flux<TechnologyResponseDto> findTechnologiesByCapacity(Long id);
}