package com.pragma.powerup.infrastructure.output.jpa.mapper;

import com.pragma.powerup.domain.model.CapacityTechnology;
import com.pragma.powerup.domain.model.Technology;
import com.pragma.powerup.infrastructure.output.jpa.entity.CapacityTechnologyEntity;
import com.pragma.powerup.infrastructure.output.jpa.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICapacityTechnologyEntityMapper {

    @Mapping(target = "capacityId", expression = "java(capacityId)")
    @Mapping(target = "technologyId", expression = "java(technologyId)")
    CapacityTechnologyEntity toEntity(Long capacityId, Long technologyId);

    CapacityTechnologyEntity toEntity(CapacityTechnology capacityTechnology);

    CapacityTechnology toCapacityTechnology(CapacityTechnologyEntity capacityTechnologyEntity);
}