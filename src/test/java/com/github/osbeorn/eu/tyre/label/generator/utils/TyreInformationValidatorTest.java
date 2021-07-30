package com.github.osbeorn.eu.tyre.label.generator.utils;

import com.github.osbeorn.eu.tyre.label.generator.exceptions.InvalidTyreInformationException;
import com.github.osbeorn.eu.tyre.label.generator.models.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class TyreInformationValidatorTest {

    @Test
    public void validateMissingUrl() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("url", exception.getField());
    }

    @Test
    public void validateMissingSupplier() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("supplier", exception.getField());
    }

    @Test
    public void validateMissingType() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .setSupplier("Continental")
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("type", exception.getField());
    }

    @Test
    public void validateMissingDimensions() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .setSupplier("Continental")
                .setIdentificationNumber("winter")
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("dimensions", exception.getField());
    }

    @Test
    public void validateMissingClassification() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .setSupplier("Continental")
                .setIdentificationNumber("winter")
                .setDimensions("205/65R15 95H")
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("classification", exception.getField());
    }

    @Test
    public void validateMissingFuelEfficiencyClass() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .setSupplier("Continental")
                .setIdentificationNumber("winter")
                .setDimensions("205/65R15 95H")
                .setClassification(TyreClassification.C1)
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("fuelEfficiencyClass", exception.getField());
    }

    @Test
    public void validateMissingWetGripClass() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .setSupplier("Continental")
                .setIdentificationNumber("winter")
                .setDimensions("205/65R15 95H")
                .setClassification(TyreClassification.C1)
                .setFuelEfficiencyClass(TyreFuelEfficiencyClass.D)
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("wetGripClass", exception.getField());
    }

    @Test
    public void validateMissingNoiseClass() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .setSupplier("Continental")
                .setIdentificationNumber("winter")
                .setDimensions("205/65R15 95H")
                .setClassification(TyreClassification.C1)
                .setFuelEfficiencyClass(TyreFuelEfficiencyClass.D)
                .setWetGripClass(TyreWetGripClass.B)
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("noiseClass", exception.getField());
    }

    @Test
    public void validateMissingNoiseLevel() {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("http://example.org/tyres/123456")
                .setSupplier("Continental")
                .setIdentificationNumber("winter")
                .setDimensions("205/65R15 95H")
                .setClassification(TyreClassification.C1)
                .setFuelEfficiencyClass(TyreFuelEfficiencyClass.D)
                .setWetGripClass(TyreWetGripClass.B)
                .setNoiseClass(TyreNoiseClass.C)
                .build();

        InvalidTyreInformationException exception = assertThrows(
                InvalidTyreInformationException.class,
                () -> TyreInformationValidator.validate(tyreInformation)
        );

        assertEquals("noiseLevel", exception.getField());
    }
}
