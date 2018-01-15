package com.app.model;

import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator {

    private StringBuilder sb;

    public void randomString(int rozmiar) {
        sb = new StringBuilder();
        char[] z = new char[rozmiar];
        for (int i = 0; i < z.length; i++) {
            z[i] = (char) (((int) (Math.random() * 26)) + (int) 'A');
            sb.append(z[i]);
        }
    }

    public StringBuilder getSb() {
        return sb;
    }
}
