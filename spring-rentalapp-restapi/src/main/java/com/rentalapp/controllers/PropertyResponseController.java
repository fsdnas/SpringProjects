package com.rentalapp.controllers;

import com.rentalapp.model.Property;
import com.rentalapp.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/property-response-api")
public class PropertyResponseController {
    private IPropertyService propertyService;

    @Autowired
    public void setPropertyService(IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/properties")
    ResponseEntity<Property> addRentalProperty(@RequestBody Property rentalProperty) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new Property");
        Property nProperty = propertyService.addRentalProperty(rentalProperty);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nProperty);
    }

    @PutMapping("/properties")
    ResponseEntity<Void> updateProperty(@RequestBody Property rentalProperty) {
        propertyService.updateRentalProperty(rentalProperty);

        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new Property");
        propertyService.updateRentalProperty(rentalProperty);

        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/properties/{propertyId}")
    ResponseEntity<String> deleteProperty(@PathVariable("propertyId") int propertyId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding new Property");
        propertyService.deleteRentalProperty(propertyId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/properties")
    ResponseEntity<List<Property>> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");
        List<Property> properties = propertyService.getAll();

        ResponseEntity<List<Property>> propertyResponse = new ResponseEntity(properties, headers, HttpStatus.OK);

        return propertyResponse;
    }

    @GetMapping("/properties/id/{propertyId}")
    ResponseEntity<Property> getPropertyById(@PathVariable("propertyId") int propertyId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");
        List<Property> properties = propertyService.getAll();
        Property property = propertyService.getById(propertyId);

        return ResponseEntity.ok().headers(headers).body(property);
    }

    @GetMapping("/properties/type/{type}")
    ResponseEntity<List<Property>> getByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(propertyService.getByType(type));
    }

    @GetMapping("/properties/furnishing/{furnishing}")
    ResponseEntity<List<Property>> getByFurnishing(@PathVariable("furnishing") String furnishing) {
        List<Property> properties = propertyService.getByFurnishing(furnishing);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/type/{type}/furnishing/{furnishing}")
    ResponseEntity<List<Property>> getByTypeAndFurnishing(@PathVariable("type") String type, @PathVariable("furnishing") String furnishing) {
        List<Property> properties = propertyService.getByTypeAndFurnishing(type, furnishing);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/rent/{start}/{end}")
    ResponseEntity<List<Property>> getByRentRange(@PathVariable("start") double start, @PathVariable("end") double end) {

        List<Property> properties = propertyService.getByRentRange(start, end);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/deposit/{deposit}")
    ResponseEntity<List<Property>> getByLesserDeposit(@PathVariable("deposit") double deposit) {
        List<Property> properties = propertyService.getByLesserDeposit(deposit);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/bedroom/{count}")
    ResponseEntity<List<Property>> getByBedroomCount(@PathVariable("count") String count) {
        List<Property> properties = propertyService.getByBedroomCount(count);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/type/{type}/bedrooms/{count}")
    ResponseEntity<List<Property>> getByTypeAndBedrooms(String type, String count) {
        List<Property> properties = propertyService.getByTypeAndBedrooms(type, count);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/amenities/{facility}")
    ResponseEntity<List<Property>> getByAmenities(@PathVariable("facility") String facilityName) {
        List<Property> properties = propertyService.getByAmenities(facilityName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/location/{location}")
    ResponseEntity<List<Property>> getByLocation(@PathVariable("location") String location) {
        List<Property> properties = propertyService.getByLocation(location);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/building/{name}")
    ResponseEntity<List<Property>> getByBuildingName(@PathVariable("name") String buildingName) {
        List<Property> properties = propertyService.getByBuildingName(buildingName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/building/{name}/bedroom/{count}")
    ResponseEntity<List<Property>> getByBuildingBedrooms(@PathVariable("name") String buildingName, @PathVariable("count") String roomCount) {
        List<Property> properties = propertyService.getByBuildingBedrooms(buildingName, roomCount);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/building/{name}/category/{category}")
    ResponseEntity<List<Property>> getByBuildingAndCategory(@PathVariable("name") String buildingName, @PathVariable("category") String categoryName) {
        List<Property> properties = propertyService.getByBuildingAndCategory(buildingName, categoryName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/city/{city}")
    ResponseEntity<List<Property>> getByCity(@PathVariable("city") String city) {
        List<Property> properties = propertyService.getByCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/category/{category}")
    ResponseEntity<List<Property>> getByCategory(@PathVariable("category") String categoryName) {
        List<Property> properties = propertyService.getByCategory(categoryName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }

    @GetMapping("/properties/location/{location}/category/{category}/type/{type}")
    ResponseEntity<List<Property>> getByLocCategoryType(@PathVariable("location") String location,
                                                        @PathVariable("category") String category,
                                                        @PathVariable("type") String type) {

        List<Property> properties = propertyService.getByLocCategoryType(location, category, type);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting All Properties");
        headers.add("info", "Property details");

        return ResponseEntity.ok().headers(headers).body(properties);
    }
}
