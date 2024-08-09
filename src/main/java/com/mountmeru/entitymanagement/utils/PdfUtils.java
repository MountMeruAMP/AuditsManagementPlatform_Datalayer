package com.mountmeru.entitymanagement.utils;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class PdfUtils {

    public static void generatePDFfromHtml(String htmlContent, FileOutputStream fos) throws IOException {
        HtmlConverter.convertToPdf(htmlContent, fos);
    }

    public static void generatePDFfromHtml(String htmlContent, String pdfDest, float width, float height) throws IOException {
        ConverterProperties converterProperties = new ConverterProperties();

        // Creating the PdfWriter and PdfDocument
//        try (FileOutputStream fos = new FileOutputStream(pdfDest);
//             PdfWriter writer = new PdfWriter(fos);
//             PdfDocument pdfDoc = new PdfDocument(writer)) {
//
//            // Set custom page size
//            pdfDoc.setDefaultPageSize(new PageSize(width, height));
//
//            // Convert HTML to PDF
//            HtmlConverter.convertToPdf(htmlContent, pdfDoc, converterProperties);
//        }

        FileOutputStream fos = new FileOutputStream(pdfDest);
        PdfWriter writer = new PdfWriter(fos);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc, new PageSize(width, height));

        // Set custom page size
        pdfDoc.setDefaultPageSize(new PageSize(width, height));

        // Convert HTML to PDF
        HtmlConverter.convertToPdf(htmlContent, pdfDoc, converterProperties);

    }
}
