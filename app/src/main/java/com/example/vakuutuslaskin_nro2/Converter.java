package com.example.vakuutuslaskin_nro2;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Converter implements Serializable {
    private Double number;

    public void Converter() {}

    public String getNumber() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String convertedNumber = decimalFormat.format(number);
        return (convertedNumber + " eur");
    }

    public void setNumber(Double number) {
        this.number = number;
    }
}
