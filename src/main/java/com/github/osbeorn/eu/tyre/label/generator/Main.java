package com.github.osbeorn.eu.tyre.label.generator;

import com.github.osbeorn.eu.tyre.label.generator.models.*;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        TyreInformation tyreInformation = new TyreInformationBuilder()
                .setUrl("https://eprel.ec.europa.eu/screen/product/tyres/481772")
                .setSupplier("Continental")
                .setIdentificationNumber("784623")
                .setDimensions("205/65R15 95H")
                .setClassification(TyreClassification.C1)
                .setFuelEfficiencyClass(TyreFuelEfficiencyClass.C)
                .setWetGripClass(TyreWetGripClass.A)
                .setNoiseLevel(72)
                .setNoiseClass(TyreNoiseClass.C)
                .setIceCapable(true)
                .build();

        TyreLabelGenerator.generate(tyreInformation);
    }
}
