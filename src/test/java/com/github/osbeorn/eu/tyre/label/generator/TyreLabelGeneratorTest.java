package com.github.osbeorn.eu.tyre.label.generator;

import com.github.osbeorn.eu.tyre.label.generator.models.*;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class TyreLabelGeneratorTest {

    private final SAXSVGDocumentFactory svgDocumentFactory = new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName());

    @Test
    @DisplayName("Test SVG document loading and parsing")
    public void testSvgDocument() {
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

        ByteArrayOutputStream svgStream = tyreLabel.asSVG();

        SVGDocument svgDocument = assertDoesNotThrow(() -> svgDocumentFactory.createSVGDocument("", new ByteArrayInputStream(svgStream.toByteArray())));

        Element supplier = svgDocument.getElementById("supplier");
        assertNotNull(supplier);
        assertEquals(tyreInformation.getSupplier(), supplier.getTextContent());

        Element identificationNumber = svgDocument.getElementById("identificationNumber");
        assertNotNull(identificationNumber);
        assertEquals(tyreInformation.getIdentificationNumber(), identificationNumber.getTextContent());

        Element dimensions = svgDocument.getElementById("dimensions");
        assertNotNull(dimensions);
        assertEquals(tyreInformation.getDimensions(), dimensions.getTextContent());

        Element classification = svgDocument.getElementById("tyreClassification");
        assertNotNull(classification);
        assertEquals(tyreInformation.getClassification().getValue(), classification.getTextContent());

        Element fuelEfficiencyClassA = svgDocument.getElementById("fuelEfficiencyClassA");
        assertNotNull(fuelEfficiencyClassA);
        assertEquals("display:none", fuelEfficiencyClassA.getAttribute("style"));

        Element fuelEfficiencyClassB = svgDocument.getElementById("fuelEfficiencyClassB");
        assertNotNull(fuelEfficiencyClassB);
        assertEquals("display:none", fuelEfficiencyClassB.getAttribute("style"));

        Element fuelEfficiencyClassC = svgDocument.getElementById("fuelEfficiencyClassC");
        assertNotNull(fuelEfficiencyClassC);
        assertEquals("display:block", fuelEfficiencyClassC.getAttribute("style"));

        Element fuelEfficiencyClassD = svgDocument.getElementById("fuelEfficiencyClassD");
        assertNotNull(fuelEfficiencyClassD);
        assertEquals("display:none", fuelEfficiencyClassD.getAttribute("style"));

        Element fuelEfficiencyClassE = svgDocument.getElementById("fuelEfficiencyClassE");
        assertNotNull(fuelEfficiencyClassE);
        assertEquals("display:none", fuelEfficiencyClassE.getAttribute("style"));

        Element wetGripClassA = svgDocument.getElementById("wetGripClassA");
        assertNotNull(wetGripClassA);
        assertEquals("display:block", wetGripClassA.getAttribute("style"));

        Element wetGripClassB = svgDocument.getElementById("wetGripClassB");
        assertNotNull(wetGripClassB);
        assertEquals("display:none", wetGripClassB.getAttribute("style"));

        Element wetGripClassC = svgDocument.getElementById("wetGripClassC");
        assertNotNull(wetGripClassC);
        assertEquals("display:none", wetGripClassC.getAttribute("style"));

        Element wetGripClassD = svgDocument.getElementById("wetGripClassD");
        assertNotNull(wetGripClassD);
        assertEquals("display:none", wetGripClassD.getAttribute("style"));

        Element wetGripClassE = svgDocument.getElementById("wetGripClassE");
        assertNotNull(wetGripClassE);
        assertEquals("display:none", wetGripClassE.getAttribute("style"));

        Element noiseLevel = svgDocument.getElementById("noiseLevel");
        assertNotNull(noiseLevel);
        assertEquals(String.valueOf(tyreInformation.getNoiseLevel()), noiseLevel.getTextContent());

        Element noiseClassA = svgDocument.getElementById("noiseClassA");
        assertNotNull(noiseClassA);
        assertEquals("display:none", noiseClassA.getAttribute("style"));

        Element noiseClassB = svgDocument.getElementById("noiseClassB");
        assertNotNull(noiseClassB);
        assertEquals("display:none", noiseClassB.getAttribute("style"));

        Element noiseClassC = svgDocument.getElementById("noiseClassC");
        assertNotNull(noiseClassC);
        assertEquals("display:block", noiseClassC.getAttribute("style"));

        Element snowCapable = svgDocument.getElementById("snowCapable");
        assertNotNull(snowCapable);
        assertEquals("display:none", snowCapable.getAttribute("style"));

        Element iceCapable = svgDocument.getElementById("iceCapable");
        assertNotNull(iceCapable);
        assertEquals("display:block", iceCapable.getAttribute("style"));
    }
}
