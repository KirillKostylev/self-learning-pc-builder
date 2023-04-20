package com.pet.project.pcbuilder.output;

import com.pet.project.pcbuilder.model.Component;
import com.pet.project.pcbuilder.model.ComponentCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
}
