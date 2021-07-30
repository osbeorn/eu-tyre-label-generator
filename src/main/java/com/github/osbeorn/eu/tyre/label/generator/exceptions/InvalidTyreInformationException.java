package com.github.osbeorn.eu.tyre.label.generator.exceptions;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class InvalidTyreInformationException extends RuntimeException {

    private final String field;

    public InvalidTyreInformationException(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
