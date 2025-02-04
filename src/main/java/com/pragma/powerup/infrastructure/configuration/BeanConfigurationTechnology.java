package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.ITechnologyServicePort;
import com.pragma.powerup.domain.spi.ITechnologyPersistencePort;
import com.pragma.powerup.domain.usecase.TechnologyUseCase;
import com.pragma.powerup.infrastructure.out.jpa.adapter.TechnologyJpaAdapter;
import com.pragma.powerup.infrastructure.out.jpa.mapper.ITechnologyEntityMapper;
import com.pragma.powerup.infrastructure.out.jpa.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfigurationTechnology {
    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyJpaAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new TechnologyUseCase(technologyPersistencePort());
    }
}