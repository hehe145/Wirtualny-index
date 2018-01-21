package com.app.service;

import com.app.model.RecrutationDays;

public interface RecrutationDaysService {

    void saveDateRecutation(RecrutationDays recrutationDays);

    RecrutationDays getRecrutationDays();

    long getDaysOfRecrutation();

}
