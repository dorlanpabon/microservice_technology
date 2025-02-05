package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.response.TechnologyResponseDto;
import com.pragma.powerup.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyResponseMapper {

    TechnologyResponseDto toTechnologyResponseDto(Technology technology);

}
