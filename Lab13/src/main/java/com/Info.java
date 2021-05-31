package com;

import java.util.Locale;

public class Info {
    public static void info(Locale x)
    {
        System.out.println(x.getDisplayLanguage());
        System.out.println(x.getDisplayCountry());
        System.out.println(x.getLanguage());
        System.out.println(x.getCountry());
    }
}
