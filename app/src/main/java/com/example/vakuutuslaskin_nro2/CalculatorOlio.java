package com.example.vakuutuslaskin_nro2;

import java.io.Serializable;

public class CalculatorOlio implements Serializable {

    private double amount = 0.0;
    private double ins_percentage = 0.0;
    private double vendor_share_percentage = 0.0;
    private double min_cost_precent = 0.0;
    private double oneMonthResult;
    private double vendorSharePer1Month;

    public double getOneMonthInsurance() {
        return this.oneMonthResult;
}
    public double getVendorSharePerMonth () {
        return this.vendorSharePer1Month;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setIns_percentage(double ins_percentage) {
        this.ins_percentage = ins_percentage;
    }


    public void setMin_cost_precent(double min_cost_precent) {
        this.min_cost_precent = min_cost_precent;
    }

    public void setVendor_share_percentage(double vendor_share_percentage) {
        this.vendor_share_percentage = vendor_share_percentage;
    }

    public double getAmount() {
        return amount;
    }
    public double getIns_percentage() {
        return ins_percentage;
    }
    public double getMin_cost_precent() {
        return min_cost_precent;
    }
    public double getVendor_share_percentage() {
        return vendor_share_percentage;
    }

    public double vendorSplitPerMonth() {
        return vendorSharePer1Month;
    }

    public double insuranceCostPerMonth() {
        return oneMonthResult;
    }

    public void setOneMonthInsurance (double amount, double ins_percentage) {
        double wholeYearResult = amount * (ins_percentage / 100);
        this.oneMonthResult =wholeYearResult / 12.0;
    }

    public void setVendorSharePerMonth (double amount, double ins_percentage, double vendor_share_percentage,  double min_cost_precent) {
        double splitPercentage = (ins_percentage - min_cost_precent);
        double vendorSharePerYear = amount * ((vendor_share_percentage / 100) * (splitPercentage / 100));
        this.vendorSharePer1Month = vendorSharePerYear / 12;
    }
}

//    private double wholeYearResult = amount * (ins_percentage / 100);
//    private double threeMonthsResult = wholeYearResult / 4.0;
//    private double oneMonthResult = wholeYearResult / 12.0;
//    private double splitPercentage = (ins_percentage - min_cost_precent);
//    private double vendorSharePerYear = amount * ((vendor_share_percentage / 100) * (splitPercentage / 100));
//    private double vendorSharePer3Months = vendorSharePerYear / 4;
//    private double vendorSharePer1Month = vendorSharePerYear / 12;