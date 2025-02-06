package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.ICapacityTechnologyServicePort;
import com.pragma.powerup.domain.spi.ICapacityTechnologyPersistencePort;
import com.pragma.powerup.domain.usecase.CapacityTechnologyUseCase;
import com.pragma.powerup.infrastructure.output.jpa.adapter.CapacityTechnologyJpaAdapter;
import com.pragma.powerup.infrastructure.output.jpa.mapper.ICapacityTechnologyEntityMapper;
import com.pragma.powerup.infrastructure.output.jpa.repository.ICapacityTechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfigurationCapacityTechnology {
    private final ICapacityTechnologyRepository capacityTechnologyRepository;
    private final ICapacityTechnologyEntityMapper categoryTechnologyEntityMapper;

    @Bean
    public ICapacityTechnologyPersistencePort capacityTechnologyPersistencePort() {
        return new CapacityTechnologyJpaAdapter(capacityTechnologyRepository, categoryTechnologyEntityMapper);
    }

    @Bean
    public ICapacityTechnologyServicePort capacityTechnologyServicePort() {
        return new CapacityTechnologyUseCase(capacityTechnologyPersistencePort());
    }

}