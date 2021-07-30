package com.github.osbeorn.eu.tyre.label.generator.models;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public enum TyreClassification {

    C1("C1"),
    C2("C2"),
    C3("C3");

    private final String value;

    TyreClassification(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
