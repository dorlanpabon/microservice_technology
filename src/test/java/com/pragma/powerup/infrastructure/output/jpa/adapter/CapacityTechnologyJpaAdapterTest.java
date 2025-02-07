package com.pragma.powerup.infrastructure.output.jpa.adapter;

import com.pragma.powerup.infrastructure.output.jpa.entity.CapacityTechnologyEntity;
import com.pragma.powerup.infrastructure.output.jpa.mapper.ICapacityTechnologyEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.ICapacityTechnologyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class CapacityTechnologyJpaAdapterTest {
    @Mock
    ICapacityTechnologyRepository capacityTechnologyRepository;
    @Mock
    ICapacityTechnologyEntityMapper capacityTechnologyEntityMapper;
    @InjectMocks
    CapacityTechnologyJpaAdapter capacityTechnologyJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity() {
        when(capacityTechnologyEntityMapper.toEntity(anyLong(), anyLong())).thenReturn(new CapacityTechnologyEntity(1L, 1L, 1L));
        when(capacityTechnologyRepository.save(any(CapacityTechnologyEntity.class))).thenReturn(Mono.empty());

        Mono<Void> result = capacityTechnologyJpaAdapter.saveTechnologiesCapacity(1L, List.of(1L));

        StepVerifier.create(result)
                .verifyComplete();

        verify(capacityTechnologyEntityMapper, times(1)).toEntity(1L, 1L);
    }
}

