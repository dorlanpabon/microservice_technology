package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.TechnologyPageRequestDto;
import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import com.pragma.powerup.application.dto.response.TechnologyResponseDto;
import com.pragma.powerup.application.handler.ITechnologyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TechnologyRestControllerTest {
    @Mock
    ITechnologyHandler technologyHandler;

    @InjectMocks
    TechnologyRestController technologyRestController;

    @Mock
    TechnologyRequestDto technologyRequestDto;

    @Mock
    TechnologyPageRequestDto technologyPageRequestDto;

    @Mock
    TechnologyResponseDto technologyResponseDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        technologyRequestDto = new TechnologyRequestDto();
        technologyRequestDto.setName("Todo");
        technologyRequestDto.setDescription("Todo");

        technologyPageRequestDto = new TechnologyPageRequestDto();
        technologyPageRequestDto.setPage(1);
        technologyPageRequestDto.setSize(10);
        technologyPageRequestDto.setDirection("ASC");

        technologyResponseDto = new TechnologyResponseDto();
        technologyResponseDto.setId(1L);
        technologyResponseDto.setName("Todo");
        technologyResponseDto.setDescription("Todo");
    }

    @Test
    void testSaveTechnology() {
        when(technologyHandler.saveTechnology(any(TechnologyRequestDto.class))).thenReturn(Mono.empty());

        Mono<Void> result = technologyRestController.saveTechnology(technologyRequestDto);

        assertNotNull(result);

        StepVerifier.create(result)
                .verifyComplete();

        verify(technologyHandler, times(1)).saveTechnology(any(TechnologyRequestDto.class));
    }

    @Test
    void testListTechnologies() {
        when(technologyHandler.listTechnologies(any())).thenReturn(Flux.just(technologyResponseDto));

        Flux<TechnologyResponseDto>  result = technologyRestController.listTechnologies(technologyPageRequestDto);

        assertNotNull(result);

        result.subscribe(response -> assertEquals("Todo", response.getName()));

        verify(technologyHandler, times(1)).listTechnologies(any());
    }
}
