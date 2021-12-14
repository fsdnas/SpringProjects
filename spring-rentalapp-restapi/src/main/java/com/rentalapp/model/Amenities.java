package com.rentalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Amenities {
    @Id
    @GeneratedValue(generator = "amenities_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "amenities_seq", sequenceName = "amenities_sequence", initialValue = 1, allocationSize = 1)
    private Integer amenitiesId;
    private String facilityName;
    private String description;

    public Amenities(String facilityName, String description) {
        this.facilityName = facilityName;
        this.description = description;
    }

}
