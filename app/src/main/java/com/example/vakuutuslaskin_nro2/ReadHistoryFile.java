package com.example.vakuutuslaskin_nro2;

public class ReadHistoryFile {
    private String username;
    private String date;
    private String insurance;
    private String vendorSplit;
    private String quote;


    public String getUsername(String token) {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate(String token) {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInsurance(String token) {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getVendorSplit() {
        return vendorSplit;
    }

    public void setVendorSplit(String vendorSplit) {
        this.vendorSplit = vendorSplit;
    }

    public String getQuote(String token) {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", date='" + date + '\'' +
                ", insurance='" + insurance + '\'' +
                ", vendorSplit='" + vendorSplit + '\'' +
                ", quote='" + quote + '\'' +
                '}';
    }
}

