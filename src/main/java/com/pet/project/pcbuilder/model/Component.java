package com.pet.project.pcbuilder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SequenceGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Component {

    @Id
    @SequenceGenerator(initialValue = 5, name = "component_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "component_sequence")
    private Long id;

    private String name;

}
