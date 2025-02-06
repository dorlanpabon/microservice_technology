package com.pragma.powerup.application.handler.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CapacityTechnologyHandlerTest {
    @Mock
    com.pragma.powerup.domain.api.ICapacityTechnologyServicePort technologyServicePort;
    @InjectMocks
    com.pragma.powerup.application.handler.impl.CapacityTechnologyHandler capacityTechnologyHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity(){
        when(technologyServicePort.saveTechnologiesCapacity(anyLong(), any(java.util.List<java.lang.Long>.class))).thenReturn(null);

        reactor.core.publisher.Mono<java.lang.Void> result = capacityTechnologyHandler.saveTechnologiesCapacity(Long.valueOf(1), java.util.List.of(Long.valueOf(1)));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme