package com.yourapp.developer.expensivemanager.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nirmal.ku on 11/15/2017.
 */
@Entity
public class AdddbModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "expense")
    private String expense;
    @ColumnInfo(name = "money_type")
    private String moneyType;
    @ColumnInfo(name = "date_time")
    private String dateTime;
    @ColumnInfo(name = "note")
    private String note;
    @ColumnInfo(name = "year")
    private String Year;
    @ColumnInfo(name = "month")
    private String month;
    @ColumnInfo(name = "to_whom")
    private String Towhom;
    @ColumnInfo(name = "for_what")
    private String Forwhat;
    @ColumnInfo(name = "money_format")
    private String format;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
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

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getTowhom() {
        return Towhom;
    }

    public void setTowhom(String towhom) {
        Towhom = towhom;
    }

    public String getForwhat() {
        return Forwhat;
    }

    public void setForwhat(String forwhat) {
        Forwhat = forwhat;
    }

   public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
