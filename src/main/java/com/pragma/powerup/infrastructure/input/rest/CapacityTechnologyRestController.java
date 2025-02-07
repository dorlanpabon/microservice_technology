package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.handler.ICapacityTechnologyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/capacity-technology")
@RequiredArgsConstructor
public class CapacityTechnologyRestController {

    private final ICapacityTechnologyHandler capacityTechnologyHandler;

    @Operation(summary = "Save technologies capacity")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Technologies capacity saved", content = @Content),
            @ApiResponse(responseCode = "400", description = "Technologies capacity not saved", content = @Content)
    })
    @PostMapping("/{capacityId}/save")
    public Mono<Void> saveTechnologiesCapacity(@PathVariable Long capacityId, @RequestBody List<Long> technologies) {
        return capacityTechnologyHandler.saveTechnologiesCapacity(capacityId, technologies).then();
    }

}