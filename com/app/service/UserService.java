package com.app.service;

import com.app.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(User user);
    boolean checkPassword(String password, String passwordConfirm);
    void sendNewPassword(User user);

    User findUserByPesel(String pesel);
}
