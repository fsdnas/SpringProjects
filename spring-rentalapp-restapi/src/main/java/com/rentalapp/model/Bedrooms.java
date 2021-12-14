package com.rentalapp.model;

public enum Bedrooms {

    ONE("1BHK"), TWO("2BHK"), THREE("3BHK"), FOUR("4BHK"), FIVE("5BHK");

    public final String count;

    private Bedrooms(String count) {
        this.count = count;
    }
    }
