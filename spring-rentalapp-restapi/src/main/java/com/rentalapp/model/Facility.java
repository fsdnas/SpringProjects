package com.rentalapp.model;

public enum Facility {
    parking("CAR PARKING"), gym("GYM"), pool("SWIMMING POOL"), sports("TENNIS COURT"), hall("COMMUNITY HALL"), play("PLAY AREA"), backup("POWER BACKUP"), lift("LIFT"), security("SECURITY");

    public final String facilityName;

    Facility(String facilityName){
        this.facilityName = facilityName;
    }
}
