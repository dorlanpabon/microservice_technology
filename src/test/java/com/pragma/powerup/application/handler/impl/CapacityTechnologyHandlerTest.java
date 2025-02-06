package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.domain.api.ICapacityTechnologyServicePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class CapacityTechnologyHandlerTest {
    @Mock
    ICapacityTechnologyServicePort technologyServicePort;
    @InjectMocks
    CapacityTechnologyHandler capacityTechnologyHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity() {
        when(technologyServicePort.saveTechnologiesCapacity(anyLong(), any(List.class))).thenReturn(Mono.empty());

        Mono<Void> result = capacityTechnologyHandler.saveTechnologiesCapacity(1L, List.of(1L));

        StepVerifier.create(result)
                .verifyComplete();

        verify(technologyServicePort, times(1)).saveTechnologiesCapacity(1L, List.of(1L));
    }
}