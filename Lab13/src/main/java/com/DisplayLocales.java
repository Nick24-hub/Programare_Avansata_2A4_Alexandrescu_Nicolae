package com;

import java.text.DateFormat;
import java.util.Locale;

public class DisplayLocales {

    static public void displayLocales() {
        Locale[] available = Locale.getAvailableLocales();
        for (Locale aLocale : available)
            System.out.println(aLocale.toString());
    }
}
