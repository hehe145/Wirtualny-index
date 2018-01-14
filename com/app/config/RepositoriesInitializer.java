package com.app.config;


import com.app.model.Country;
import com.app.model.Role;
import com.app.repository.CountryRepository;
import com.app.repository.RoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoriesInitializer {


    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Bean
    InitializingBean init() {

        return () -> {
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

