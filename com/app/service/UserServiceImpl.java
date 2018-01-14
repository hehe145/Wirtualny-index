package com.app.service;


import com.app.controller.exception.BadPassword;
import com.app.model.Role;
import com.app.model.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        if (this.checkPassword(user.getPassword(), user.getPasswordConfirm())) {
            Role role = roleService.findRole(Role.Types.ROLE_USER);
            List roles = Arrays.asList(role);
            user.setRoles(new HashSet<>(roles));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.saveAndFlush(user);
        } else {
            throw new BadPassword();
        }
    }

    @Override
    public boolean checkPassword(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByPesel(s);
        return convertToUserDetails(user);
    }

    private UserDetails convertToUserDetails(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getTypes().toString()));
        }
        return new org.springframework.security.core.userdetails.User(user.getPesel(), user.getPassword(), grantedAuthorities);
    }
}
