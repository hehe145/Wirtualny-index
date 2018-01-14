package com.app.service;

import com.app.model.Role;
import com.app.model.User;
import com.app.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRole(Role.Types types) {
        Role role = roleRepository.findRoleByTypes(types);
        return role;
    }
}
