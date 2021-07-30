package com.github.osbeorn.eu.tyre.label.generator.models;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class TyreInformation {

    /**
     * EPREL database url
     */
    private final String url;

    /**
     * Tyre brand, eg. Goodyear
     */
    private final String supplier;

    /**
     * Tyre identification number
     */
    private final String identificationNumber;

    /**
     * Tyre dimensions, eg. P215/65+R15
     */
    private final String dimensions;

    /**
     * Tyre classification (C1, C2, C3)
     */
    private final TyreClassification classification;

    /**
     * Tyre fuel efficiency class (A, B, C, D, E)
     */
    private final TyreFuelEfficiencyClass fuelEfficiencyClass;

    /**
     * Tyre wet grip class (A, B, C, D, E)
     */
    private final TyreWetGripClass wetGripClass;

    /**
     * Noise class (A, B, or C).
     */
    private final TyreNoiseClass noiseClass;

    /**
     * Noise level in dB.
     */
    private final Integer noiseLevel;

    /**
     * Is tyre snow capable (optional).
     */
    private final Boolean snowCapable;

    /**
     * Is tyre ice capable (optional).
     */
    private final Boolean iceCapable;

    public TyreInformation(String url, String supplier, String identificationNumber, String dimensions, TyreClassification classification, TyreFuelEfficiencyClass fuelEfficiencyClass, TyreWetGripClass wetGripClass, TyreNoiseClass noiseClass, Integer noiseLevel, Boolean snowCapable, Boolean iceCapable) {
        this.url = url;
        this.supplier = supplier;
        this.identificationNumber = identificationNumber;
        this.dimensions = dimensions;
        this.classification = classification;
        this.fuelEfficiencyClass = fuelEfficiencyClass;
        this.wetGripClass = wetGripClass;
        this.noiseClass = noiseClass;
        this.noiseLevel = noiseLevel;
        this.snowCapable = snowCapable;
        this.iceCapable = iceCapable;
    }

    public String getUrl() {
        return url;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getDimensions() {
        return dimensions;
    }

    public TyreClassification getClassification() {
        return classification;
    }

    public TyreFuelEfficiencyClass getFuelEfficiencyClass() {
        return fuelEfficiencyClass;
    }

    public TyreWetGripClass getWetGripClass() {
        return wetGripClass;
    }

    public TyreNoiseClass getNoiseClass() {
        return noiseClass;
    }

    public Integer getNoiseLevel() {
        return noiseLevel;
    }

    public Boolean isSnowCapable() {
        return snowCapable;
    }

    public Boolean isIceCapable() {
        return iceCapable;
    }
}
