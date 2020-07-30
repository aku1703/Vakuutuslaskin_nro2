package com.example.vakuutuslaskin_nro2;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateOlio implements Serializable {

    public DateOlio() {
    }

    public String getFormattedDate() {
        final String formattedDate = this.formattedDate;
        final String date = formattedDate;
        return date;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    String formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

}
