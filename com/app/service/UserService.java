package com.app.service;

import com.app.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void save(User user);
    boolean checkPassword(String password, String passwordConfirm);
    void sendNewPassword(User user);

    User findUserByEmail(String emial);
    User findUserByPesel(String pesel);

    void changePhoto(String photoName, String pesel);

    void changePassword(User user, String pesel);

    void saveDirectionToUser(long id, String name);
}
