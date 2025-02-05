package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import com.pragma.powerup.application.handler.ITechnologyHandler;
import com.pragma.powerup.application.mapper.ITechnologyRequestMapper;
import com.pragma.powerup.application.mapper.ITechnologyResponseMapper;
import com.pragma.powerup.domain.api.ITechnologyServicePort;
import com.pragma.powerup.domain.model.Technology;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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


}