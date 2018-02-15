package com.yourapp.developer.expensivemanager.Model;

/**
 * Created by nirmal.ku on 11/15/2017.
 */
public class AddExpensive{
    private String expensive;
    private String moneyType;
    private String dateTime;
    private String note;
    private String month;
    private String year;

    public AddExpensive(String expensive, String moneyType, String dateTime, String note, String month, String year) {
        this.expensive = expensive;
        this.moneyType = moneyType;
        this.dateTime = dateTime;
        this.note = note;
        this.month = month;
        this.year = year;
    }



    public String getExpensive() {
        return expensive;
    }

    public void setExpensive(String expensive) {
        this.expensive = expensive;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
