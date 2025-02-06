package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.handler.ICapacityTechnologyHandler;
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

class CapacityTechnologyRestControllerTest {
    @Mock
    ICapacityTechnologyHandler capacityTechnologyHandler;
    @InjectMocks
    CapacityTechnologyRestController capacityTechnologyRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity() {
        when(capacityTechnologyHandler.saveTechnologiesCapacity(anyLong(), any(List.class))).thenReturn(Mono.empty());

        Mono<Void> result = capacityTechnologyRestController.saveTechnologiesCapacity(1L, List.of(1L));

        StepVerifier.create(result)
                .verifyComplete();

        verify(capacityTechnologyHandler, times(1)).saveTechnologiesCapacity(1L, List.of(1L));
    }
}