package com.app.service;

import com.app.model.DateChange;
import com.app.model.RecrutationDays;
import com.app.repository.RecrutationDaysRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class RecrutationDaysServiceImpl implements RecrutationDaysService {

    @Autowired
    private RecrutationDaysRepositroy recrutationDaysRepositroy;

    @Override
    public void saveDateRecutation(RecrutationDays recrutationDays) {
        RecrutationDays recrutationDays1 = null;
        if (recrutationDays != null) {
            if (!recrutationDaysRepositroy.findAll().isEmpty()) {
                recrutationDays1 = recrutationDaysRepositroy.findAll().get(0);
                recrutationDays1.setDate(recrutationDays.getDate());
                recrutationDaysRepositroy.save(recrutationDays1);
            } else {
                recrutationDaysRepositroy.save(recrutationDays);
            }
        }
    }

    @Override
    public RecrutationDays getRecrutationDays() {
        RecrutationDays recrutationDays = null;
        if (recrutationDaysRepositroy.findAll().isEmpty() == false) {
            recrutationDays = recrutationDaysRepositroy.findAll().get(0);
        }
        return recrutationDays;
    }

    @Override
    public long getDaysOfRecrutation() {
        RecrutationDays recrutationDays = getRecrutationDays();
        long days = 0;
        if (recrutationDays != null) {
            Date date = new Date();
            DateChange dateChange = actualDateChange(date);
            DateChange dataBase = dataWithDataBase(recrutationDays);
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.set(dateChange.getRok(), dateChange.getMies(), dateChange.getDzien());
            c2.set(dataBase.getRok(), dataBase.getMies(), dataBase.getDzien());

            long differenceInMillis = c2.getTimeInMillis() - c1.getTimeInMillis();
            Calendar result = Calendar.getInstance();
            result.setTimeInMillis(differenceInMillis);

            long liczbaMSwDobie = 1000 * 60 * 60 * 24;
            days = result.getTimeInMillis() / liczbaMSwDobie;

        }
        return days;
    }

    private DateChange actualDateChange(Date date) {
        DateChange dateChange = null;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        dateChange = new DateChange(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));

        return dateChange;
    }

    private DateChange dataWithDataBase(RecrutationDays recrutationDays) {
        DateChange dataBaseData = null;
        System.out.println("Nowa" + recrutationDays.getDate());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(recrutationDays.getDate());
        dataBaseData = new DateChange(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(dataBaseData.getRok() + " " + dataBaseData.getMies() + " " +
                dataBaseData.getDzien());
        return dataBaseData;
    }
}
