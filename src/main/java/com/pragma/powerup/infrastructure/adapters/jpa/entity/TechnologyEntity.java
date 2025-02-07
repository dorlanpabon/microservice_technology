package com.pragma.powerup.infrastructure.adapters.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("technologies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TechnologyEntity {
    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

}
