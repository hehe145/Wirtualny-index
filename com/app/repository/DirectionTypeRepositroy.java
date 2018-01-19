package com.app.repository;

import com.app.model.DirectionTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionTypeRepositroy extends JpaRepository<DirectionTypes, Long> {
}
