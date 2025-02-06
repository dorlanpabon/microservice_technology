package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.TechnologyPageRequestDto;
import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import com.pragma.powerup.application.dto.response.TechnologyResponseDto;
import com.pragma.powerup.application.handler.ICapacityTechnologyHandler;
import com.pragma.powerup.application.handler.ITechnologyHandler;
import com.pragma.powerup.application.mapper.ITechnologyRequestMapper;
import com.pragma.powerup.application.mapper.ITechnologyResponseMapper;
import com.pragma.powerup.domain.api.ICapacityTechnologyServicePort;
import com.pragma.powerup.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CapacityTechnologyHandler implements ICapacityTechnologyHandler {

    private final ICapacityTechnologyServicePort technologyServicePort;

    @Override
    public Mono<Void> saveTechnologiesCapacity(Long capacityId, List<Long> technologies) {
        return technologyServicePort.saveTechnologiesCapacity(capacityId, technologies);
    }

}