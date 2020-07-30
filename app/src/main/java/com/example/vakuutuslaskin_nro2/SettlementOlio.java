package com.example.vakuutuslaskin_nro2;

import java.io.Serializable;

public class SettlementOlio implements Serializable {

    private double rent;
    private double remainingLeaseItems;
    private double residualValue;
    final double expense = 70.00;

    // This calculator is for rental agreement
    public void setRemainingLease(double rent, double remainingLeaseItems) {
        double remainingLease = (rent * remainingLeaseItems + expense);
    }

    //This calculator is for Leasing agreements
    public void setRemainingLease(double rent, double remainingLeaseItems, double residualValue) {
        this.rent = rent;
        this.remainingLeaseItems = remainingLeaseItems;
        this.residualValue = residualValue;
    }

    public double getRemainingLease() {
        double result = (rent * remainingLeaseItems) + residualValue + expense;
        return result;
    }
}