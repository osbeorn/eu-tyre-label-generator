package com.github.osbeorn.eu.tyre.label.generator.models;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public enum TyreNoiseClass {

    A("A"),
    B("B"),
    C("C");

    private final String value;

    TyreNoiseClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
