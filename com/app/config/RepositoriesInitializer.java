package com.app.config;


import com.app.model.*;
import com.app.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RepositoriesInitializer {


    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DirectionRepositroy directionRepositroy;

    @Autowired
    private DirectionTypeRepositroy directionTypeRepositroy;

    @Bean
    InitializingBean init() {

        return () -> {

            if (directionRepositroy.findAll().isEmpty()) {
                DirectionTypes dzienne = new DirectionTypes();
                dzienne.setName("Dzienne");
                directionTypeRepositroy.save(dzienne);

                DirectionTypes zaoczne = new DirectionTypes();
                zaoczne.setName("Zaoczne");
                directionTypeRepositroy.save(zaoczne);

                Direction informatykaDzienne = new Direction();
                informatykaDzienne.setName("Informatyka");
                informatykaDzienne.setDirectionTypes(dzienne);
                directionRepositroy.save(informatykaDzienne);

                Direction informatykaZaoczne = new Direction();
                informatykaZaoczne.setName("Informatyka");
                informatykaZaoczne.setDirectionTypes(zaoczne);
                directionRepositroy.save(informatykaZaoczne);

                User user = userRepository.findUserByPesel("95030410314");
                if (user != null) {
                    List<Direction> list = new ArrayList<>();
                    list.add(informatykaZaoczne);
                    user.setDirections(list);
                    userRepository.save(user);

                }
            }

            if (roleRepository.findAll().isEmpty()) {
                Role user = new Role(Role.Types.ROLE_USER);
                roleRepository.save(user);

                Role admin = new Role(Role.Types.ROLE_ADMIN);
                roleRepository.save(admin);

                Role dziekanat = new Role(Role.Types.ROLE_DZIEKANAT);
                roleRepository.save(dziekanat);

                Role dziekan = new Role(Role.Types.ROLE_DZIEKAN);
                roleRepository.save(dziekan);


            }
            if (countryRepository.findAll().isEmpty()) {
                countryRepository.save(new Country("Niemcy"));
                countryRepository.save(new Country("Rosja"));
                countryRepository.save(new Country("Wielka Brytania"));
                countryRepository.save(new Country("Polska"));
            }
        };
    }

}

