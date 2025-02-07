package com.pragma.powerup.infrastructure.entrypoints.handler.impl;

import com.pragma.powerup.infrastructure.entrypoints.handler.ICapacityTechnologyHandler;
import com.pragma.powerup.domain.api.ICapacityTechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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