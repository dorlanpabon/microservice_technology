package com.pragma.powerup.infrastructure.entrypoints;

import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyPageRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.request.TechnologyRequestDto;
import com.pragma.powerup.infrastructure.entrypoints.dto.response.TechnologyResponseDto;
import com.pragma.powerup.infrastructure.entrypoints.handler.ITechnologyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestController {

    private final ITechnologyHandler technologyHandler;

    @Operation(summary = "Add a new technology")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Technology created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Technology already exists", content = @Content)
    })
    @PostMapping("/")
    public Mono<Void> saveTechnology(@Valid @RequestBody TechnologyRequestDto technologyRequestDto) {
        return technologyHandler.saveTechnology(technologyRequestDto).then();
    }

    @Operation(summary = "List of technologies paginated by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of technologies", content = @Content)
    })
    @PostMapping("/list")
    public Flux<TechnologyResponseDto> listTechnologies(@Valid @RequestBody TechnologyPageRequestDto technologyPageRequestDto) {
        return technologyHandler.listTechnologies(technologyPageRequestDto);
    }

    @Operation(summary = "List of technologies by capacity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of technologies", content = @Content)
    })
    @GetMapping("/{id}")
    public Flux<TechnologyResponseDto> findTechnologiesByCapacity(@PathVariable Long id) {
        return technologyHandler.findTechnologiesByCapacity(id);
    }
}