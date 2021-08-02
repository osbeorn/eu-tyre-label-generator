package com.github.osbeorn.eu.tyre.label.generator;

import com.github.osbeorn.eu.tyre.label.generator.exceptions.TyreLabelGeneratorException;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.w3c.dom.svg.SVGDocument;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author osbeorn
 * @since 1.0.0
 */
public class TyreLabel {

    private final SVGDocument svgDocument;

    TyreLabel(SVGDocument svgDocument) {
        this.svgDocument = svgDocument;
    }

    public ByteArrayOutputStream asPNG() throws TyreLabelGeneratorException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            TranscoderInput transcoderInput = new TranscoderInput(svgDocument);

            TranscoderOutput transcoderOutput = new TranscoderOutput(byteArrayOutputStream);
            PNGTranscoder pngTranscoder = new PNGTranscoder();

            pngTranscoder.transcode(transcoderInput, transcoderOutput);
        } catch (TranscoderException e) {
            throw new TyreLabelGeneratorException("Failed to export tyre label as PNG stream.", e);
        }

        return byteArrayOutputStream;
    }

    public void toPNGFile(String fileName) throws TyreLabelGeneratorException {
        try {
            TranscoderInput transcoderInput = new TranscoderInput(svgDocument);

            OutputStream outputStream = new FileOutputStream(fileName);
            TranscoderOutput transcoderOutput = new TranscoderOutput(outputStream);
            PNGTranscoder pngTranscoder = new PNGTranscoder();

            pngTranscoder.transcode(transcoderInput, transcoderOutput);

            outputStream.flush();
            outputStream.close();
        } catch (IOException | TranscoderException e) {
            throw new TyreLabelGeneratorException("Failed to export tyre label to PNG file.", e);
        }
    }

    public ByteArrayOutputStream asSVG() throws TyreLabelGeneratorException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            SVGGraphics2D graphics = new SVGGraphics2D(svgDocument);

            Writer out = new OutputStreamWriter(byteArrayOutputStream, StandardCharsets.UTF_8);
            graphics.stream(svgDocument.getDocumentElement(), out, false, false);

            out.flush();
            out.close();
        } catch (Exception e) {
            throw new TyreLabelGeneratorException("Failed to export tyre label as SVG stream.", e);
        }

        return byteArrayOutputStream;
    }

    public void toSVGFile(String fileName) throws TyreLabelGeneratorException {
        try {
            SVGGraphics2D graphics = new SVGGraphics2D(svgDocument);

            Writer out = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8);
            graphics.stream(svgDocument.getDocumentElement(), out, false, false);

            out.flush();
            out.close();
        } catch (Exception e) {
            throw new TyreLabelGeneratorException("Failed to export tyre label to SVG file.", e);
        }
    }
}
