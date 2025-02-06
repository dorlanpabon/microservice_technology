package com.pragma.powerup.infrastructure.input.rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CapacityTechnologyRestControllerTest {
    @Mock
    com.pragma.powerup.application.handler.ICapacityTechnologyHandler capacityTechnologyHandler;
    @InjectMocks
    com.pragma.powerup.infrastructure.input.rest.CapacityTechnologyRestController capacityTechnologyRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity(){
        when(capacityTechnologyHandler.saveTechnologiesCapacity(anyLong(), any(java.util.List<java.lang.Long>.class))).thenReturn(null);

        reactor.core.publisher.Mono<java.lang.Void> result = capacityTechnologyRestController.saveTechnologiesCapacity(Long.valueOf(1), java.util.List.of(Long.valueOf(1)));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme