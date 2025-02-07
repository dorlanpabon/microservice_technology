package com.pragma.powerup.infrastructure.entrypoints.handler;

import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyPageRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.response.TechnologyResponseDto;
import com.pragma.powerup.infrastructure.entrypoints.handler.impl.TechnologyHandler;
import com.pragma.powerup.infrastructure.entrypoints.mapper.ITechnologyRequestMapper;
import com.pragma.powerup.infrastructure.entrypoints.mapper.ITechnologyResponseMapper;
import com.pragma.powerup.domain.api.ITechnologyServicePort;
import com.pragma.powerup.domain.model.Technology;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
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
    TechnologyResponseDto technologyResponseDto;
    @Mock
    TechnologyPageRequestDto technologyPageRequestDto;
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

        technologyResponseDto = new TechnologyResponseDto();
        technologyResponseDto.setId(1L);
        technologyResponseDto.setName("name");
        technologyResponseDto.setDescription("description");

        technologyPageRequestDto = new TechnologyPageRequestDto();
        technologyPageRequestDto.setPage(1);
        technologyPageRequestDto.setSize(10);
        technologyPageRequestDto.setDirection("ASC");
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

    @Test
    void testListTechnologies() {
        when(technologyServicePort.listTechnologies(1, 10, "ASC")).thenReturn(Flux.just(technology));
        when(technologyResponseMapper.toTechnologyResponseDto(technology)).thenReturn(technologyResponseDto);

        Flux<TechnologyResponseDto> result = technologyHandler.listTechnologies(technologyPageRequestDto);

        StepVerifier.create(result)
                .expectNext(technologyResponseDto)
                .verifyComplete();

        verify(technologyServicePort, times(1)).listTechnologies(1, 10, "ASC");
        verify(technologyResponseMapper, times(1)).toTechnologyResponseDto(technology);
    }

    @Test
    void testFindTechnologiesByCapacity() {
        when(technologyServicePort.findTechnologiesByCapacity(1L)).thenReturn(Flux.just(technology));
        when(technologyResponseMapper.toTechnologyResponseDto(technology)).thenReturn(technologyResponseDto);

        Flux<TechnologyResponseDto> result = technologyHandler.findTechnologiesByCapacity(1L);

        StepVerifier.create(result)
                .expectNext(technologyResponseDto)
                .verifyComplete();

        verify(technologyServicePort, times(1)).findTechnologiesByCapacity(1L);
        verify(technologyResponseMapper, times(1)).toTechnologyResponseDto(technology);
    }
}