package com.rentalapp.controllers;

import com.rentalapp.model.Property;
import com.rentalapp.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-api")
public class PropertyController {
    private IPropertyService propertyService;

    @Autowired
    public void setPropertyService(IPropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @PostMapping("/properties")
    Property addRentalProperty(Property property) {
        return propertyService.addRentalProperty(property);
    }

    @PutMapping("/properties")
    void updateRentalProperty(Property property) {
        propertyService.updateRentalProperty(property);
    }

    @DeleteMapping("/properties/{propertyId}")
    void deleteRentalProperty(@PathVariable("propertyId") int propertyId) {
        propertyService.deleteRentalProperty(propertyId);
    }

    @GetMapping("/properties/id/{propertyId}")
    Property getById(@PathVariable("propertyId") int propertyId) {
        return propertyService.getById(propertyId);
    }

    //query table

    @GetMapping("/properties")
    List<Property> getAll() {
        return propertyService.getAll();
    }

    @GetMapping("/properties/type/{type}")
    List<Property> getByType(@PathVariable("type") String type) {
        return propertyService.getByType(type);
    }

    @GetMapping("/properties/furnishing/{furnishing}")
    List<Property> getByFurnishing(@PathVariable("furnishing") String furnishing) {
        return propertyService.getByFurnishing(furnishing);
    }

    @GetMapping("/properties/type/{type}/furnishing/{furnishing}")
    List<Property> getByTypeAndFurnishing(@PathVariable("type") String type, @PathVariable("furnishing") String furnishing) {
        return propertyService.getByTypeAndFurnishing(type, furnishing);
    }

    @GetMapping("/properties/range/start/{start}/end/{end}")
    List<Property> getByRentRange(@PathVariable("start") double start, @PathVariable("end") double end) {
        return propertyService.getByRentRange(start, end);
    }

    @GetMapping("/properties/deposit/{deposit}")
    List<Property> getByLesserDeposit(@PathVariable("deposit") double deposit) {
        return propertyService.getByLesserDeposit(deposit);
    }

    @GetMapping("/properties/bedrooms/count/{count}")
    List<Property> getByBedroomCount(@PathVariable("count") String count) {
        return propertyService.getByBedroomCount(count);
    }

    @GetMapping("/properties/type/{type}/count/{count}")
    List<Property> getByTypeAndBedrooms(@PathVariable("type") String type, @PathVariable("count") String count) {
        return propertyService.getByTypeAndBedrooms(type, count);
    }

    @GetMapping("/properties/facilities/{facilities}")
    List<Property> getByAmenities(@PathVariable("facilities") String facilities) {
        return propertyService.getByAmenities(facilities);
    }

    @GetMapping("/properties/location/{location}")
    List<Property> getByLocation(@PathVariable("location") String location) {
        return propertyService.getByLocation(location);
    }

    @GetMapping("/properties/buildingName/{buildingName}")
    List<Property> getByBuildingName(@PathVariable("buildingName") String buildingName) {
        return propertyService.getByBuildingName(buildingName);
    }

    @GetMapping("/properties/buildingName/{buildingName}/roomCount/{roomCount}")
    List<Property> getByBuildingBedrooms(@PathVariable("buildingName") String buildingName, @PathVariable("roomCount") String roomCount) {
        return propertyService.getByBuildingBedrooms(buildingName, roomCount);
    }

    @GetMapping("/properties/buildingName/{buildingName}/categoryName/{categoryName}")
    List<Property> getByBuildingAndCategory(@PathVariable("buildingName") String buildingName, @PathVariable("categoryName") String categoryName) {
        return propertyService.getByBuildingAndCategory(buildingName, categoryName);
    }

    @GetMapping("/properties/city/{city}")
    List<Property> getByCity(@PathVariable("city") String city) {
        return propertyService.getByCity(city);
    }

    @GetMapping("/properties/categoryName/{categoryName}")
    List<Property> getByCategory(@PathVariable("categoryName") String categoryName) {
        return propertyService.getByCategory(categoryName);
    }

    @GetMapping("/properties/location/{location}/category/{category}/type/{type}")
    List<Property> getByLocCategoryType(@PathVariable("location") String location, @PathVariable("category") String category, @PathVariable("type") String type) {
        return propertyService.getByLocCategoryType(location, category, type);
    }
}
