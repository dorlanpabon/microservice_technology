package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import com.pragma.powerup.application.handler.ITechnologyHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TechnologyRestControllerTest {
    @Mock
    ITechnologyHandler technologyHandler;

    @InjectMocks
    TechnologyRestController technologyRestController;

    private TechnologyRequestDto technologyRequestDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        technologyRequestDto = new TechnologyRequestDto();
        technologyRequestDto.setName("Todo");
        technologyRequestDto.setDescription("Todo");
    }

    @Test
    void testSaveTechnology() {
        when(technologyHandler.saveTechnology(any(TechnologyRequestDto.class))).thenReturn(Mono.empty());

        Mono<ResponseEntity<Void>> result = technologyRestController.saveTechnology(technologyRequestDto);

        assertNotNull(result);

        result.subscribe(response -> assertEquals(ResponseEntity.ok().build(), response));

        verify(technologyHandler, times(1)).saveTechnology(any(TechnologyRequestDto.class));
    }
}
