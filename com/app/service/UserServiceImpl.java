package com.app.service;


import com.app.controller.exception.BadPassword;
import com.app.controller.exception.BadUser;
import com.app.model.PasswordGenerator;
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

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private PasswordGenerator passwordGenerator;

    @Override
    public void save(User user) {
        User find = userRepository.findUserByPesel(user.getPesel());
        if (this.checkPassword(user.getPassword(), user.getPasswordConfirm()) && find == null) {
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
    @Transactional
    public void sendNewPassword(User user) {
        User find = userRepository.findUserByPesel(user.getPesel());

        if (find != null) {
            passwordGenerator.randomString(6);
            String password = "Twoje nowe hasło to " + passwordGenerator.getSb();
            userRepository.changeUserPassword(passwordEncoder.encode(passwordGenerator.getSb()), user.getPesel());
            sendEmailService.sendEmail(user.getEmail(), "Dziennik elektroniczny nowe hasło ", password);
        } else {
            throw new BadUser();
        }

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
