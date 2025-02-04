package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import reactor.core.publisher.Mono;

public interface ITechnologyHandler {

    Mono<Void> saveTechnology(TechnologyRequestDto technologyRequestDto);

}