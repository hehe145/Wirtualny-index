package com.app.service;

import com.app.model.Country;
import com.app.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountry() {
        List<Country> countryList = countryRepository.findAll();
        return countryList;
    }
}
