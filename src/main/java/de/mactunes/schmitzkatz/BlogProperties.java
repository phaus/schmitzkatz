package de.mactunes.schmitzkatz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class BlogProperties extends Properties {

    private static final String VALUE_TRUE = "true",
            VALUE_FALSE = "false";

    private boolean getBooleanValueForString(String string) {
        if (null == string) {
            return false;
        }

        return (VALUE_TRUE.equals(string)) ? true : false;
    }

    private int getIntFromString(String string) {
        int parsed = 0;

        try {
            parsed = Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
        }

        return parsed;
    }

    private Locale getLocale() {
        if (this.getProperty("language").toLowerCase().startsWith("de")) {
            return Locale.GERMAN;
        }
        return Locale.US;
    }

    public String getRFC822Date(){
        return getRFC822Date(new Date());
    }
    
    public String getRFC822Date(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss Z", getLocale());
        return dateFormat.format(date);
    }
}
