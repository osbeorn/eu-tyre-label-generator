package com.github.osbeorn.eu.tyre.label.generator.utils;

import com.github.osbeorn.eu.tyre.label.generator.exceptions.InvalidTyreInformationException;
import com.github.osbeorn.eu.tyre.label.generator.models.TyreInformation;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class TyreInformationValidator {

    public static void validate(TyreInformation tyreInformation) throws InvalidTyreInformationException {
        if (tyreInformation.getUrl() == null || tyreInformation.getUrl().isEmpty()) {
            throw new InvalidTyreInformationException("url");
        }

        if (tyreInformation.getSupplier() == null || tyreInformation.getSupplier().isEmpty()) {
            throw new InvalidTyreInformationException("supplier");
        }

        if (tyreInformation.getIdentificationNumber() == null || tyreInformation.getIdentificationNumber().isEmpty()) {
            throw new InvalidTyreInformationException("identificationNumber");
        }

        if (tyreInformation.getDimensions() == null || tyreInformation.getDimensions().isEmpty()) {
            throw new InvalidTyreInformationException("dimensions");
        }

        if (tyreInformation.getClassification() == null) {
            throw new InvalidTyreInformationException("classification");
        }

        if (tyreInformation.getFuelEfficiencyClass() == null) {
            throw new InvalidTyreInformationException("fuelEfficiencyClass");
        }

        if (tyreInformation.getWetGripClass() == null) {
            throw new InvalidTyreInformationException("wetGripClass");
        }

        if (tyreInformation.getNoiseClass() == null) {
            throw new InvalidTyreInformationException("noiseClass");
        }

        if (tyreInformation.getNoiseLevel() == null) {
            throw new InvalidTyreInformationException("noiseLevel");
        }

        if (tyreInformation.isSnowCapable() == null) {
            throw new InvalidTyreInformationException("snowCapable");
        }

        if (tyreInformation.isIceCapable() == null) {
            throw new InvalidTyreInformationException("iceCapable");
        }
    }
}
