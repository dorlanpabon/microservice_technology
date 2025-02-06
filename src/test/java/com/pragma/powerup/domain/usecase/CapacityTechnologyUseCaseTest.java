package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.constants.DomainConstants;
import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.spi.ICapacityTechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

class CapacityTechnologyUseCaseTest {
    @Mock
    private ICapacityTechnologyPersistencePort capacityTechnologyPersistencePort;

    @InjectMocks
    private CapacityTechnologyUseCase capacityTechnologyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologiesCapacity_Success() {
        Long capacityId = 1L;
        List<Long> technologies = List.of(1L, 2L, 3L);

        when(capacityTechnologyPersistencePort.saveTechnologiesCapacity(capacityId, technologies)).thenReturn(Mono.empty());

        Mono<Void> result = capacityTechnologyUseCase.saveTechnologiesCapacity(capacityId, technologies);

        StepVerifier.create(result)
                .verifyComplete();

        verify(capacityTechnologyPersistencePort, times(1)).saveTechnologiesCapacity(capacityId, technologies);
    }

    @Test
    void testSaveTechnologiesCapacity_InvalidCapacityId_ShouldThrowException() {
        Mono<Void> result = capacityTechnologyUseCase.saveTechnologiesCapacity(null, List.of(1L));

        StepVerifier.create(result)
                .expectErrorSatisfies(throwable -> {
                    assert throwable instanceof DomainException;
                    assert ((DomainException) throwable).getMessage().equals(DomainConstants.INVALID_CAPACITY_ID);
                })
                .verify();

        verify(capacityTechnologyPersistencePort, never()).saveTechnologiesCapacity(anyLong(), any());
    }

    @Test
    void testSaveTechnologiesCapacity_EmptyTechnologyList_ShouldThrowException() {
        Long capacityId = 1L;
        List<Long> emptyList = List.of();

        Mono<Void> result = capacityTechnologyUseCase.saveTechnologiesCapacity(capacityId, emptyList);

        StepVerifier.create(result)
                .expectErrorSatisfies(throwable -> {
                    assert throwable instanceof DomainException;
                    assert ((DomainException) throwable).getMessage().equals(DomainConstants.EMPTY_TECHNOLOGY_LIST);
                })
                .verify();

        verify(capacityTechnologyPersistencePort, never()).saveTechnologiesCapacity(anyLong(), any());
    }

}
