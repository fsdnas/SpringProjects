package com.rentalapp.repository;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPropertyRepository extends JpaRepository<Property, Integer> {
    //derived
    List<Property> findByType(Type type);


    List<Property> findByType(String type) throws PropertyNotFoundException;

    List<Property> findByFurnishing(Furnishing furnishing) throws PropertyNotFoundException;

    List<Property> findByTypeAndFurnishing(Type type, Furnishing furnishing) throws PropertyNotFoundException;




    List<Property> findByBedrooms(String roomCount) throws PropertyNotFoundException;

    List<Property> findByTypeAndBedrooms(Type type, String bedrooms) throws PropertyNotFoundException;


    @Query("from Property p inner join p.amenities a where a.facilityName=?1")
    List<Property> findByAmenities(String facilityName) throws PropertyNotFoundException;


    @Query("from Property p where p.expectedRent between ?1 and ?2")
    List<Property> findByRentRange(double start, double end) throws PropertyNotFoundException;

    @Query("from Property p where p.securityDeposit <= ?1 ")
    List<Property> findByLesserDeposit(double deposit) throws PropertyNotFoundException;

    @Query("from Property p inner join p.address a where a.location=?1 ")
    List<Property> findByLocation(String location) throws PropertyNotFoundException;

    @Query("from Property p inner join p.address a where a.buildingName=?1 ")
    List<Property> findByBuildingName(String buildingName) throws PropertyNotFoundException;

    @Query("from Property p inner join p.address a where a.location=?1 and p.bedrooms=?2")
    List<Property> findByBuildingBedrooms(String location, String roomCount) throws PropertyNotFoundException;

    @Query("from Property p inner join p.address a inner join p.categories c where a.buildingName=?1 and c.categoryName=?2")
    List<Property> findByBuildingAndCategory(String buildingName, String categoryName) throws PropertyNotFoundException;

    @Query("from Property p inner join p.address a where a.city=?1 ")
    List<Property> findByCity(String city) throws PropertyNotFoundException;

    @Query("from Property p inner join p.categories c where c.categoryName=?1 ")
    List<Property> findByCategory(String categoryName) throws PropertyNotFoundException;

    @Query("from Property p inner join p.address a inner join p.categories c where a.location=?1 and c.categoryName=?2 and p.type=?3")
    List<Property> findByLocCategoryType(String location, String category, Type type) throws PropertyNotFoundException;


//    //custom
//    @Query("from Property p inner join p.address a where a.location=?1")
//    List<Property> findByLocation(String name);
//
//    @Query("from Property p inner join p.address a where a.location=?1")
//    List<Property> findByCategory(String category);
//
//    @Query("from Property p inner join p.address a where a.city=?1")
//    List<Property> findByCity(String city);
//
//    @Query("from Property p where p.securityDeposit<=?1")
//    List<Property> findByLesserDeposit(double deposit);
//
//    @Query("from Property p where p.expectedRent between ?1 and ?2")
//    List<Property> findByExpectedRent(double start, double end);

}
