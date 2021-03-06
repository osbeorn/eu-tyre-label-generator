package com.github.osbeorn.eu.tyre.label.generator;

import com.github.osbeorn.eu.tyre.label.generator.exceptions.TyreLabelGeneratorException;
import com.github.osbeorn.eu.tyre.label.generator.models.TyreInformation;
import com.github.osbeorn.eu.tyre.label.generator.utils.TyreInformationValidator;
import io.nayuki.qrcodegen.QrCode;
import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.svg.SVGDocument;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class TyreLabelGenerator {

    private static final Logger LOG = Logger.getLogger(TyreLabelGenerator.class.getName());

    private static final String TEMPLATE_PATH = "/templates/eu-tyre-label-template-2020.svg";

    // element IDs and ID formats
    private static final String QR_CODE_ID = "qrCode";
    private static final String SUPPLIER_ID = "supplier";
    private static final String IDENTIFICATION_NUMBER_ID = "identificationNumber";
    private static final String DIMENSIONS_ID = "dimensions";
    private static final String TYRE_CLASSIFICATION_ID = "tyreClassification";
    private static final String FUEL_EFFICIENCY_CLASS_ID_FORMAT = "fuelEfficiencyClass%s"; // append class to get correct ID, eq. fuelEfficiencyClassD
    private static final String WET_GRIP_CLASS_ID_FORMAT = "wetGripClass%s"; // append class to get correct ID, eq. wetGripClassA
    private static final String NOISE_LEVEL_ID = "noiseLevel";
    private static final String NOISE_CLASS_ID_FORMAT = "noiseClass%s"; // append class to get correct ID, eq. noiseLevelB
    private static final String SNOW_CAPABLE_ID = "snowCapable";
    private static final String ICE_CAPABLE_ID = "iceCapable";

    static {
        try {
            // load and set fonts
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();

            graphicsEnvironment.registerFont(Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(TyreLabelGenerator.class.getResourceAsStream("/fonts/calibrib.ttf"))));
            graphicsEnvironment.registerFont(Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(TyreLabelGenerator.class.getResourceAsStream("/fonts/verdana.ttf"))));
            graphicsEnvironment.registerFont(Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(TyreLabelGenerator.class.getResourceAsStream("/fonts/verdanab.ttf"))));
        } catch (FontFormatException | IOException e) {
            LOG.log(Level.SEVERE, "Unable to load and set fonts.", e);
        }
    }

    public static TyreLabel generate(TyreInformation tyreInformation) throws TyreLabelGeneratorException {
        TyreInformationValidator.validate(tyreInformation);

        SVGDocument svgDocument = loadSvgDocument();

        try {
            // qr code
            String qrCodeSvgString = generateQrCodeSvgString(tyreInformation.getUrl());
            SvgDocumentTransformer.setElementAttributeValue(svgDocument, QR_CODE_ID, "d", qrCodeSvgString);
            // supplier
            SvgDocumentTransformer.setElementTextContent(svgDocument, SUPPLIER_ID, tyreInformation.getSupplier());
            // tyreType
            SvgDocumentTransformer.setElementTextContent(svgDocument, IDENTIFICATION_NUMBER_ID, tyreInformation.getIdentificationNumber());
            // dimensions
            SvgDocumentTransformer.setElementTextContent(svgDocument, DIMENSIONS_ID, tyreInformation.getDimensions());
            // tyreClassification
            SvgDocumentTransformer.setElementTextContent(svgDocument, TYRE_CLASSIFICATION_ID, String.valueOf(tyreInformation.getClassification()));
            // fuelEfficiencyClass
            SvgDocumentTransformer.showElement(svgDocument, String.format(FUEL_EFFICIENCY_CLASS_ID_FORMAT, tyreInformation.getFuelEfficiencyClass().getValue()));
            // wetGripClass
            SvgDocumentTransformer.showElement(svgDocument, String.format(WET_GRIP_CLASS_ID_FORMAT, tyreInformation.getWetGripClass().getValue()));
            // noiseLevel
            SvgDocumentTransformer.setElementTextContent(svgDocument, NOISE_LEVEL_ID, String.valueOf(tyreInformation.getNoiseLevel()));
            // noiseClass
            SvgDocumentTransformer.showElement(svgDocument, String.format(NOISE_CLASS_ID_FORMAT, tyreInformation.getNoiseClass().getValue()));
            // snowCapable
            if (tyreInformation.isSnowCapable()) {
                SvgDocumentTransformer.showElement(svgDocument, SNOW_CAPABLE_ID);
            }
            // iceCapable
            if (tyreInformation.isIceCapable()) {
                SvgDocumentTransformer.showElement(svgDocument, ICE_CAPABLE_ID);
            }
        } catch (Exception e) {
            int i = 0;
        }

        return new TyreLabel(svgDocument);
    }

    private static SVGDocument loadSvgDocument() throws TyreLabelGeneratorException {
        try {
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory svgDocumentFactory = new SAXSVGDocumentFactory(parser);

            URL resourceUrl = TyreLabelGenerator.class.getResource(TEMPLATE_PATH);
            if (resourceUrl == null) {
                throw new IOException(String.format("Resource '%s' not found.", TEMPLATE_PATH));
            }

            return svgDocumentFactory.createSVGDocument(resourceUrl.toString());
        } catch (IOException e) {
            String message = String.format("Unable to construct SVGDocument instance: %s", e.getMessage());
            LOG.log(Level.SEVERE, message, e);

            throw new TyreLabelGeneratorException(message, e);
        }
    }

    private static String generateQrCodeSvgString(String url) {
        QrCode qrCode = QrCode.encodeText(url, QrCode.Ecc.MEDIUM);
        String qrCodeSvg = qrCode.toSvgString(0);

        // extract d attribute of <path> element
        Pattern pattern = Pattern.compile("d=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(qrCodeSvg);
        if (matcher.find()) {
            return matcher.group(1);
        }

        return "";
    }
}
