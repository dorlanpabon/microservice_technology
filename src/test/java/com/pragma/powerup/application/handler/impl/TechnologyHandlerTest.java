package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import com.pragma.powerup.application.mapper.ITechnologyRequestMapper;
import com.pragma.powerup.application.mapper.ITechnologyResponseMapper;
import com.pragma.powerup.domain.api.ITechnologyServicePort;
import com.pragma.powerup.domain.model.Technology;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

class TechnologyHandlerTest {
    @Mock
    ITechnologyServicePort technologyServicePort;
    @Mock
    ITechnologyRequestMapper technologyRequestMapper;
    @Mock
    ITechnologyResponseMapper technologyResponseMapper;
    @InjectMocks
    TechnologyHandler technologyHandler;
    @Mock
    TechnologyRequestDto technologyRequestDto;
    @Mock
    Technology technology;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        technologyRequestDto = new TechnologyRequestDto();
        technologyRequestDto.setName("name");
        technologyRequestDto.setDescription("description");

        technology = new Technology();
        technology.setId(1L);
        technology.setName("name");
        technology.setDescription("description");
    }

    @Test
    void testSaveTechnology() {
        when(technologyRequestMapper.toTechnology(technologyRequestDto)).thenReturn(technology);
        when(technologyServicePort.saveTechnology(any())).thenReturn(Mono.empty());

        Mono<Void> result = technologyHandler.saveTechnology(technologyRequestDto);

        StepVerifier.create(result)
                .verifyComplete();

        verify(technologyRequestMapper, times(1)).toTechnology(technologyRequestDto);
        verify(technologyServicePort, times(1)).saveTechnology(any());
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme