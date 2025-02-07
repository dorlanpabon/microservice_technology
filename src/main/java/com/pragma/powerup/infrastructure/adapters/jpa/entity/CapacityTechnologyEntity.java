package com.pragma.powerup.infrastructure.adapters.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("capacity_technology")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CapacityTechnologyEntity {
    @Id
    private Long id;

    @Column("capacity_id")
    private Long capacityId;

    @Column("technology_id")
    private Long technologyId;
}
