package com.app.repository;

import com.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByPesel(String pesel);

    User findUserByEmail(String emial);
    @Modifying
    @Query("UPDATE User u set u.password =?1 WHERE u.pesel =?2 ")
    int changeUserPassword(String password, String pesel);

    @Modifying
    @Query("UPDATE User u set u.photoName = ?1 WHERE u.pesel =?2")
    int changePhoto(String photoName, String pesel);

}
