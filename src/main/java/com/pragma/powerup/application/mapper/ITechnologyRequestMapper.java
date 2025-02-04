package com.pragma.powerup.application.mapper;

import com.pragma.powerup.application.dto.request.TechnologyRequestDto;
import com.pragma.powerup.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyRequestMapper {

    Technology toTechnology(TechnologyRequestDto technologyRequestDto);

}
