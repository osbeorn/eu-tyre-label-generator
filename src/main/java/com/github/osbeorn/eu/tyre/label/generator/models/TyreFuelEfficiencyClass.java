package com.github.osbeorn.eu.tyre.label.generator.models;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public enum TyreFuelEfficiencyClass {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private final String value;

    TyreFuelEfficiencyClass(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
