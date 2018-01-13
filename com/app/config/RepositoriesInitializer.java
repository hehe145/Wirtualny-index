package com.app.config;


import com.app.model.Country;
import com.app.repository.CountryRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RepositoriesInitializer {


    @Autowired
    private CountryRepository countryRepository;


    @Bean
    InitializingBean init() {

        return () -> {
            if (countryRepository.findAll().isEmpty()) {
                countryRepository.save(new Country("Niemcy"));
                countryRepository.save(new Country("Rosja"));
                countryRepository.save(new Country("Wielka Brytania"));
                countryRepository.save(new Country("Polska"));
            }
        };
    }

}

