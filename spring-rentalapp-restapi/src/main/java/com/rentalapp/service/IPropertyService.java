package com.rentalapp.service;

import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.Property;

import java.util.List;


public interface IPropertyService {
    Property addRentalProperty(Property property);

    void updateRentalProperty(Property property);

    void deleteRentalProperty(int propertyId);

    Property getById(int propertyId) throws PropertyNotFoundException;

    //query table
    List<Property> getAll();
    List<Property> getByType(String type)throws PropertyNotFoundException;
    List<Property> getByFurnishing(String furnishing)throws PropertyNotFoundException;
    List<Property> getByTypeAndFurnishing(String type, String furnishing)throws PropertyNotFoundException;
    List<Property> getByRentRange(double start,double end)throws PropertyNotFoundException;
    List<Property> getByLesserDeposit(double deposit)throws PropertyNotFoundException;
    List<Property> getByBedroomCount(String count)throws PropertyNotFoundException;
    List<Property> getByTypeAndBedrooms(String type, String count)throws PropertyNotFoundException;
    List<Property> getByAmenities(String facilities)throws PropertyNotFoundException;
    List<Property> getByLocation(String location)throws PropertyNotFoundException;
    List<Property> getByBuildingName(String buildingName)throws PropertyNotFoundException;
    List<Property> getByBuildingBedrooms(String buildingName,String roomCount)throws PropertyNotFoundException;


    List<Property> getByBuildingAndCategory(String buildingName,String categoryName)throws PropertyNotFoundException;
    List<Property> getByCity(String city)throws PropertyNotFoundException;
    List<Property> getByCategory(String categoryName)throws PropertyNotFoundException;

    List<Property> getByLocCategoryType(String location,String category,String type)throws PropertyNotFoundException;

}
