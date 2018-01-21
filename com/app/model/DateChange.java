package com.app.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DateChange {

    private int rok;
    private int mies;
    private int dzien;

    public DateChange(int rok, int mies, int dzien) {
        this.rok = rok;
        this.mies = mies;
        this.dzien = dzien;
    }
}
