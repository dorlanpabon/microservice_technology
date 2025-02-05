package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.domain.model.Technology;
import com.pragma.powerup.infrastructure.out.jpa.entity.TechnologyEntity;
import com.pragma.powerup.infrastructure.out.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.ITechnologyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class TechnologyJpaAdapterTest {
    @Mock
    ITechnologyRepository technologyRepository;
    @Mock
    ITechnologyEntityMapper technologyEntityMapper;
    @InjectMocks
    TechnologyJpaAdapter technologyJpaAdapter;
    @Mock
    Technology technology;
    @Mock
    TechnologyEntity technologyEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        technology = new Technology();
        technology.setId(1L);
        technology.setName("name");
        technology.setDescription("description");

        technologyEntity = new TechnologyEntity();
        technologyEntity.setId(1L);
        technologyEntity.setName("name");
        technologyEntity.setDescription("description");

    }

    @Test
    void testSaveTechnology() {
        when(technologyEntityMapper.toEntity(any(Technology.class))).thenReturn(technologyEntity);
        when(technologyRepository.save(any(TechnologyEntity.class))).thenReturn(Mono.just(technologyEntity));
        when(technologyEntityMapper.toTechnology(any(TechnologyEntity.class))).thenReturn(technology);

        Mono<Technology> result = technologyJpaAdapter.saveTechnology(technology);

        StepVerifier.create(result)
                .expectNext(technology)
                .verifyComplete();

        verify(technologyEntityMapper, times(1)).toEntity(technology);
        verify(technologyRepository, times(1)).save(technologyEntity);
    }

    @Test
    void testFindTechnologyByName() {
        when(technologyRepository.findByName(anyString())).thenReturn(Mono.empty());

        Mono<Technology> result = technologyJpaAdapter.findTechnologyByName("name");

        StepVerifier.create(result)
                .verifyComplete();

        verify(technologyRepository, times(1)).findByName("name");
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme