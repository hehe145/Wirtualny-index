package com.app.service;

import com.app.model.Direction;

import java.util.List;

public interface DirectionService {

    List<Direction> findAll();

    Direction findById(long id);

}
