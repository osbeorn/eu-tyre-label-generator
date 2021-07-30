package com.github.osbeorn.eu.tyre.label.generator;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

/**
 * @author osbeorn
 * @since 1.0.0
 */
class SvgDocumentTransformer {

    private static final String VISIBILITY_ATTRIBUTE_NAME = "style";
    private static final String VISIBILITY_ATTRIBUTE_VISIBLE_VALUE = "display:block";
    private static final String VISIBILITY_ATTRIBUTE_HIDDEN_VALUE = "display:none";

    public static void setElementTextContent(SVGDocument svgDocument, String elementId, String text) {
        Element textElement = svgDocument.getElementById(elementId);
        textElement.setTextContent(text);
    }

    public static void setElementAttributeValue(SVGDocument svgDocument, String elementId, String attributeName, String attributeValue) {
        Element element = svgDocument.getElementById(elementId);
        element.setAttribute(attributeName, attributeValue);
    }

    public static void showElement(SVGDocument svgDocument, String elementId) {
        setElementAttributeValue(svgDocument, elementId, VISIBILITY_ATTRIBUTE_NAME, VISIBILITY_ATTRIBUTE_VISIBLE_VALUE);
    }

    public static void hideElement(SVGDocument svgDocument, String elementId) {
        setElementAttributeValue(svgDocument, elementId, VISIBILITY_ATTRIBUTE_NAME, VISIBILITY_ATTRIBUTE_HIDDEN_VALUE);
    }
}
