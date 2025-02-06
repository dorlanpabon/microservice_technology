package com.pragma.powerup.infrastructure.output.jpa.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
class CapacityTechnologyJpaAdapterTest {
    @Mock
    com.pragma.powerup.infrastructure.output.jpa.repository.ICapacityTechnologyRepository capacityTechnologyRepository;
    @Mock
    com.pragma.powerup.infrastructure.output.jpa.mapper.ICapacityTechnologyEntityMapper capacityTechnologyEntityMapper;
    @InjectMocks
    com.pragma.powerup.infrastructure.output.jpa.adapter.CapacityTechnologyJpaAdapter capacityTechnologyJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity(){
        when(capacityTechnologyEntityMapper.toEntity(anyLong(), anyLong())).thenReturn(new com.pragma.powerup.infrastructure.output.jpa.entity.CapacityTechnologyEntity(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1)));

        reactor.core.publisher.Mono<java.lang.Void> result = capacityTechnologyJpaAdapter.saveTechnologiesCapacity(Long.valueOf(1), java.util.List.of(Long.valueOf(1)));
        Assertions.assertEquals(null, result);
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme