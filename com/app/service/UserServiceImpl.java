package com.app.service;


import com.app.controller.exception.BadPassword;
import com.app.controller.exception.BadUser;
import com.app.controller.exception.YouSaved;
import com.app.model.*;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Autowired
    private DirectionService directionService;

    @Override
    public void save(User user) {
        User find = userRepository.findUserByPesel(user.getPesel());
        if (this.checkPassword(user.getPassword(), user.getPasswordConfirm())
                && find == null) {
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
    public User findUserByEmail(String emial) {
        User user = userRepository.findUserByEmail(emial);
        return user;
    }

    @Transactional
    @Override
    public User findUserByPesel(String pesel) {
        User user = userRepository.findUserByPesel(pesel);
        return user;
    }

    @Override
    @Transactional
    public void changePhoto(String photoName, String pesel) {
        userRepository.changePhoto(photoName, pesel);
    }

    @Override
    @Transactional
    public void changePassword(User user, String pesel) {
        User find = userRepository.findUserByPesel(pesel);
        if (find != null) {
            if (user.getPassword().equals(user.getPasswordConfirm())) {
                userRepository.changeUserPassword(passwordEncoder.encode(user.getPassword()), pesel);
            }
        } else {
            throw new BadPassword();
        }
    }

    @Override
    public void saveDirectionToUser(long id, String name) {
        User user = findUserByPesel(name);
        Direction direction = directionService.findById(id);
        if (userDirectionExist(direction, user) == false) {
            List<Direction> directionList = new ArrayList<>();
            directionList.add(direction);
            user.setDirections(directionList);
            userRepository.save(user);
        } else {
            throw new YouSaved();
        }
    }

    @Override
    public void deleteUserDirection(String userName) {
        User user = userRepository.findUserByPesel(userName);
        if (user != null) {
            List<Direction> directions = new ArrayList<>();
            user.setDirections(directions);
            userRepository.save(user);
        }
    }

    @Override
    public void editForm(User user) {
        if (user != null) {
            userRepository.save(user);
        }
    }

    @Override
    @Transactional
    public void changeMaturaPhoto(String photo, String pesel) {
        userRepository.changeMaturaPhoto(photo, pesel);
    }

    @Override
    public List<User> getAllUsersRegistrated() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public void deleteUserWithDirection(long id) {
        User user = userRepository.findById(id).get();
        List<Direction> directionList = new ArrayList<>();
        user.setDirections(directionList);
        userRepository.save(user);
    }


    private boolean userDirectionExist(Direction direction, User user) {
        boolean is = false;
        for (int i = 0; i < user.getDirections().size(); i++) {
            if (user.getDirections().get(i).getName().equals(direction.getName())
                    && user.getDirections().get(i).getDirectionTypes().
                    getName().equals(direction.getDirectionTypes().getName())) {
                is = true;
                break;
            }
        }
        return is;
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
