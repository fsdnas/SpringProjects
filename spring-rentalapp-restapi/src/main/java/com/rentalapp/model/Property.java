package com.rentalapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Property {
    @Column(length = 30)
    private String name;
    @Id
    @GeneratedValue(generator = "property_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "property_seq", sequenceName = "property_sequence", initialValue = 100, allocationSize = 1)
    private Integer propertyId;
    @Enumerated(EnumType.STRING)
    private Type type;

    //    @Enumerated(EnumType.STRING)
    private String bedrooms;

    @Enumerated(EnumType.STRING)
    private Furnishing furnishing;

    private String area;
    @Column(name = "expectedrent")
    private double expectedRent;
    @Column(name = "securitydeposit")
    private double securityDeposit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL) //this is the foreign  key that will be added to amenities table
    @JoinColumn(name = "property_id")
    @ToString.Exclude//prevent creating a new junction table
    private Set<Amenities> amenities;

    @ManyToMany
    @JoinTable(name = "property_category", joinColumns = @JoinColumn(name = "property_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ToString.Exclude
    private Set<Category> categories;

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setAmenities(Set<Amenities> amenities) {
        this.amenities = amenities;
    }

    public Set<Amenities> getAmenities() {
        return amenities;
    }


    public Property(String name, Type type, String bedrooms, Furnishing furnishing, String area, double expectedRent, double securityDeposit, Address address, Set<Amenities> amenities, Set<Category> categories) {
        this.name = name;
        this.type = type;
        this.bedrooms = bedrooms;
        this.furnishing = furnishing;
        this.area = area;
        this.expectedRent = expectedRent;
        this.securityDeposit = securityDeposit;
        this.address = address;
        this.amenities = amenities;
        this.categories = categories;
    }


}
