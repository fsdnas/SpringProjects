package com.rentalapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@NoArgsConstructor
@ToString
@Entity
public class Address {
    private String doorNo;
    @Id
    @GeneratedValue(generator = "address_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_seq", sequenceName = "address_sequence", initialValue = 1000, allocationSize = 10)
    private Integer addressId;
    @Column(length = 30, name = "buildingname")
    private String buildingName;
    @Column(length = 30, name = "streetname")
    private String streetName;
    @Column(length = 30)
    private String location;
    @Column(length = 30)
    private String city;
    @Column(length = 30)
    private String state;
    @Column(length = 30, name = "zipcode")
    private int zipCode;

    public Address(String doorNo, String buildingName, String streetName, String location, String city, String state, int zipCode) {
        this.doorNo = doorNo;
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.location = location;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }


}
