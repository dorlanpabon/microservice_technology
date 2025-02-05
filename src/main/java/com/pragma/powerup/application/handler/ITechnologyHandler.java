package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.TechnologyPageRequestDto;
import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import com.pragma.powerup.application.dto.response.TechnologyResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyHandler {

    Mono<Void> saveTechnology(TechnologyRequestDto technologyRequestDto);

    Flux<TechnologyResponseDto> listTechnologies(TechnologyPageRequestDto technologyPageRequestDto);
}