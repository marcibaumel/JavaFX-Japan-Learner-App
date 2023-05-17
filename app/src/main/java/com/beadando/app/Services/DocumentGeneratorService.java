package com.beadando.app.Services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DocumentGeneratorService {
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);

    public void generateDocument(int percentage){
        try {
            Document document = new Document();
            Date date = new Date() ;
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            OutputStream outputStream = new FileOutputStream(new File("C:\\Result\\"+dateFormatter.format(date)+".pdf"));
            PdfWriter.getInstance(document, outputStream);
            document.open();

            Paragraph preface = new Paragraph();
            document.add(new Paragraph("Japan Exam Result Document", catFont));
            document.add(new Paragraph("Date: " + dateFormatter.format(date), smallBold));

            generateEmptyLines(3, document);

            document.add(new Paragraph("Actual user: " + System.getProperty("user.name"), smallBold));
            document.add(new Paragraph("Result Percentage: " + percentage +"%", subFont));

            generateEmptyLines(5, document);
            document.add(new Paragraph("Have a nice day!", catFont));

            document.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void generateEmptyLines(int emptyLineCount, Document document) throws DocumentException {
        for(int i =0; i< emptyLineCount; i++){
            document.add(new Paragraph(" " ));
        }
    }

}
