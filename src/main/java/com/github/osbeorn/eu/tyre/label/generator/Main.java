package com.github.osbeorn.eu.tyre.label.generator;

import com.github.osbeorn.eu.tyre.label.generator.models.*;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        long sum = 0;

        long numRuns = 1;
        for (int i = 0; i < numRuns; i++) {
            long start = System.currentTimeMillis();

            System.out.printf("Starting[%d] ...%n", i + 1);

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

            TyreLabel tyreLabel = TyreLabelGenerator.generate(tyreInformation);
//            tyreLabel.toPNGFile("eu-tyre-label-2020.png");
            tyreLabel.toSVGFile("eu-tyre-label-2020.svg");

            long end = System.currentTimeMillis();
            long diff = end - start;

            sum += diff;

            System.out.printf("Finished[%d] in %sms%n", i + 1, diff);
        }

        System.out.printf("Average %sms", sum / numRuns);
    }
}
