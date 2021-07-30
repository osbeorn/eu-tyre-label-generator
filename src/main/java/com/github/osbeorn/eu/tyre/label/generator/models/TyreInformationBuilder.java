package com.github.osbeorn.eu.tyre.label.generator.models;

public class TyreInformationBuilder {

    private String url;
    private String supplier;
    private String identificationNumber;
    private String dimensions;
    private TyreClassification classification;
    private TyreFuelEfficiencyClass fuelEfficiencyClass;
    private TyreWetGripClass wetGripClass;
    private TyreNoiseClass noiseClass;
    private Integer noiseLevel;
    private Boolean snowCapable = false;
    private Boolean iceCapable = false;

    public TyreInformationBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public TyreInformationBuilder setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public TyreInformationBuilder setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
        return this;
    }

    public TyreInformationBuilder setDimensions(String dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public TyreInformationBuilder setClassification(TyreClassification classification) {
        this.classification = classification;
        return this;
    }

    public TyreInformationBuilder setFuelEfficiencyClass(TyreFuelEfficiencyClass fuelEfficiencyClass) {
        this.fuelEfficiencyClass = fuelEfficiencyClass;
        return this;
    }

    public TyreInformationBuilder setWetGripClass(TyreWetGripClass wetGripClass) {
        this.wetGripClass = wetGripClass;
        return this;
    }

    public TyreInformationBuilder setNoiseClass(TyreNoiseClass noiseClass) {
        this.noiseClass = noiseClass;
        return this;
    }

    public TyreInformationBuilder setNoiseLevel(Integer noiseLevel) {
        this.noiseLevel = noiseLevel;
        return this;
    }

    public TyreInformationBuilder setSnowCapable(Boolean snowCapable) {
        this.snowCapable = snowCapable;
        return this;
    }

    public TyreInformationBuilder setIceCapable(Boolean iceCapable) {
        this.iceCapable = iceCapable;
        return this;
    }

    public TyreInformation build() {
        return new TyreInformation(
                url, supplier, identificationNumber, dimensions, classification, fuelEfficiencyClass, wetGripClass,
                noiseClass, noiseLevel, snowCapable, iceCapable
        );
    }
}