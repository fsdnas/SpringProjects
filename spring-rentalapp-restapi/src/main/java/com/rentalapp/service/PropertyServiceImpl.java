package com.rentalapp.service;

import com.rentalapp.controllers.PropertyResponseController;
import com.rentalapp.exceptions.PropertyNotFoundException;
import com.rentalapp.model.*;
import com.rentalapp.repository.IPropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements IPropertyService {

    private Logger logger = LoggerFactory.getLogger(PropertyResponseController.class);
    private IPropertyRepository propertyRepository;

    @Autowired
    public void setPropertyRepository(IPropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property addRentalProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public void updateRentalProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public void deleteRentalProperty(int propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    @Override
    public Property getById(int propertyId) throws PropertyNotFoundException {

        logger.debug("inside get property by id method in service layer");
        logger.info("calling get property by id method");
        return propertyRepository.findById(propertyId).orElseThrow(() -> {
                    logger.error("property not found");
                    throw new PropertyNotFoundException("Invalid Id");
                }
        );
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Override
    public List<Property> getByType(String type) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByType(Type.valueOf(type));
        if (properties.isEmpty()) {
            logger.warn("throws exception if properties are empty");
            logger.error("property with this tpe not found");
            throw new PropertyNotFoundException("Invalid type");
        }
        return properties;
    }

    @Override
    public List<Property> getByFurnishing(String furnishing) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByFurnishing(Furnishing.valueOf(furnishing));
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByTypeAndFurnishing(String type, String furnishing) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByTypeAndFurnishing(Type.valueOf(type), Furnishing.valueOf(furnishing));
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByRentRange(double start, double end) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByRentRange(start, end);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid range");
        return properties;
    }

    @Override
    public List<Property> getByLesserDeposit(double deposit) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByLesserDeposit(deposit);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid deposit");
        return properties;
    }

    @Override
    public List<Property> getByBedroomCount(String count) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBedrooms(count);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByTypeAndBedrooms(String type, String count) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByTypeAndBedrooms(Type.valueOf(type), count);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByAmenities(String facilityName) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByAmenities(facilityName);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByLocation(String location) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByLocation(location);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Location");
        return properties;
    }

    @Override
    public List<Property> getByBuildingName(String buildingName) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBuildingName(buildingName);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByBuildingBedrooms(String buildingName, String roomCount) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBuildingBedrooms(buildingName, roomCount);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByBuildingAndCategory(String buildingName, String categoryName) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByBuildingAndCategory(buildingName, categoryName);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByCity(String city) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByCity(city);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByCategory(String categoryName) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByCategory(categoryName);
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }

    @Override
    public List<Property> getByLocCategoryType(String location, String category, String type) throws PropertyNotFoundException {
        List<Property> properties = propertyRepository.findByLocCategoryType(location, category, Type.valueOf(type));
        if (properties.isEmpty())
            throw new PropertyNotFoundException("Invalid Input");
        return properties;
    }
}
