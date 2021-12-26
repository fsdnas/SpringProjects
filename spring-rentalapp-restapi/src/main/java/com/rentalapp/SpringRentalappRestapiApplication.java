package com.rentalapp;

import com.rentalapp.model.*;
import com.rentalapp.service.ICategoryService;
import com.rentalapp.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class SpringRentalappRestapiApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringRentalappRestapiApplication.class, args);
    }

    @Autowired
    private IPropertyService propertyService;

    @Autowired
    private ICategoryService categoryService;

    public void run(String... args) throws Exception {


//        Address address = new Address("S211", "Mahesh Babu Building", "Road No 2", "Banjara Hills", "Hyderabad", "Telangana", 500079);
//        Amenities amenities3 = new Amenities(Facility.gym.facilityName, "Gym with cardio");
//        Amenities amenities1 = new Amenities(Facility.lift.facilityName, "16 capacity");
//        Amenities amenities2 = new Amenities(Facility.parking.facilityName, "four and two wheeler");
//        Set<Amenities> amenitiesSet = new HashSet<>(Arrays.asList(amenities1, amenities2, amenities3));
//
//        //Many to Many
//
//        Category category1 = new Category("Boys & Girls");
//        categoryService.addCategory(category1);
//        Category category2 = categoryService.getById(51);
//        Category category3 = categoryService.getById(52);
//        Set<Category> categories = new HashSet<>(Arrays.asList(category1, category2, category3));
//        Property property = new Property("3BHK", Type.APARTMENT, Bedrooms.THREE.count, Furnishing.SEMI_FURNISHED, "2300 SQFT", 40000, 100000, address, amenitiesSet, categories);
//        System.out.println("Property" + propertyService.addRentalProperty(property));


    }
}
