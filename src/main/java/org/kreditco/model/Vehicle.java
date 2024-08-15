package org.kreditco.model;

public class Vehicle {

    private String type;
    private String condition;
    private int year;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Vehicle(String type, String condition, int year) {
        this.type = type;
        this.condition = condition;
        this.year = year;
    }

    public Vehicle() {
    }
}
