package com.app.service;

import com.app.model.Direction;
import com.app.repository.DirectionRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionRepositroy directionRepositroy;

    @Override
    public List<Direction> findAll() {
        List<Direction> directions = directionRepositroy.findAll();
        return directions;
    }

    @Override
    public Direction findById(long id) {
        Direction direction = directionRepositroy.findById(id).get();
        return direction;
    }
}
