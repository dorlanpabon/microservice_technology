package com.pragma.powerup.domain.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CapacityTechnologyUseCaseTest {
    @Mock
    com.pragma.powerup.domain.spi.ICapacityTechnologyPersistencePort capacityTechnologyPersistencePort;
    @InjectMocks
    com.pragma.powerup.domain.usecase.CapacityTechnologyUseCase capacityTechnologyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity(){
        when(capacityTechnologyPersistencePort.saveTechnologiesCapacity(anyLong(), any(java.util.List<java.lang.Long>.class))).thenReturn(null);

        reactor.core.publisher.Mono<java.lang.Void> result = capacityTechnologyUseCase.saveTechnologiesCapacity(Long.valueOf(1), java.util.List.of(Long.valueOf(1)));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme