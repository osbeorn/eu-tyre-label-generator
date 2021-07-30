package com.github.osbeorn.eu.tyre.label.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class TyreLabelGeneratorTest {

    @Test
    @DisplayName("Test SVG document loading and parsing")
    public void testSvgDocument() {
        new TyreLabelGenerator().generate(null);
    }
}
