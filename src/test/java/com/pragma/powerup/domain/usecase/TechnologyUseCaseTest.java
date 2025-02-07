package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.exception.DomainException;
import com.pragma.powerup.domain.model.Technology;
import com.pragma.powerup.domain.spi.ITechnologyPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class TechnologyUseCaseTest {
    @Mock
    ITechnologyPersistencePort technologyPersistencePort;

    @InjectMocks
    TechnologyUseCase technologyUseCase;

    private Technology technology;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        technology = new Technology();
        technology.setId(1L);
        technology.setName("name");
        technology.setDescription("description");
    }

    @Test
    void testSaveTechnology_Success() {
        when(technologyPersistencePort.findTechnologyByName(anyString())).thenReturn(Mono.empty());
        when(technologyPersistencePort.saveTechnology(any(Technology.class))).thenReturn(Mono.just(technology));

        Mono<Void> result = technologyUseCase.saveTechnology(technology);

        StepVerifier.create(result)
                .verifyComplete();

        verify(technologyPersistencePort, times(1)).findTechnologyByName("name");
        verify(technologyPersistencePort, times(1)).saveTechnology(technology);
    }

    @Test
    void testSaveTechnology_AlreadyExists() {
        when(technologyPersistencePort.findTechnologyByName(any())).thenReturn(Mono.just(technology));

        Mono<Void> result = technologyUseCase.saveTechnology(technology);

        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

        verify(technologyPersistencePort, times(1)).findTechnologyByName("name");
        verify(technologyPersistencePort, never()).saveTechnology(any(Technology.class));
    }

    @Test
    void testSaveTechnology_NameNull() {
        technology.setName(null);

        Mono<Void> result = technologyUseCase.saveTechnology(technology);

        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

        verify(technologyPersistencePort, never()).findTechnologyByName(anyString());
        verify(technologyPersistencePort, never()).saveTechnology(any(Technology.class));
    }

    @Test
    void testSaveTechnology_NameTooLong() {
        technology.setName("a".repeat(51));

        Mono<Void> result = technologyUseCase.saveTechnology(technology);

        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

        verify(technologyPersistencePort, never()).findTechnologyByName(anyString());
        verify(technologyPersistencePort, never()).saveTechnology(any(Technology.class));
    }

    @Test
    void testSaveTechnology_DescriptionNull() {
        technology.setDescription(null);

        Mono<Void> result = technologyUseCase.saveTechnology(technology);

        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

        verify(technologyPersistencePort, never()).findTechnologyByName(anyString());
        verify(technologyPersistencePort, never()).saveTechnology(any(Technology.class));
    }

    @Test
    void testSaveTechnology_DescriptionTooLong() {
        technology.setDescription("a".repeat(91));

        Mono<Void> result = technologyUseCase.saveTechnology(technology);

        StepVerifier.create(result)
                .expectError(DomainException.class)
                .verify();

        verify(technologyPersistencePort, never()).findTechnologyByName(anyString());
        verify(technologyPersistencePort, never()).saveTechnology(any(Technology.class));
    }

    @Test
    void testListTechnologies() {
        when(technologyPersistencePort.listTechnologies(anyInt(), anyInt(), anyString())).thenReturn(Flux.just(technology));

        Flux<Technology> result = technologyUseCase.listTechnologies(1, 10, "ASC");

        StepVerifier.create(result)
                .expectNext(technology)
                .verifyComplete();

        verify(technologyPersistencePort, times(1)).listTechnologies(1, 10, "ASC");
    }

    @Test
    void testFindTechnologiesByCapacity() {
        when(technologyPersistencePort.findTechnologiesByCapacity(anyLong())).thenReturn(Flux.just(technology));

        Flux<Technology> result = technologyUseCase.findTechnologiesByCapacity(1L);

        StepVerifier.create(result)
                .expectNext(technology)
                .verifyComplete();

        verify(technologyPersistencePort, times(1)).findTechnologiesByCapacity(1L);
    }
}
