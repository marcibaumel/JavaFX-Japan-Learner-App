package com.beadando.app.Services;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DocumentGeneratorService {
    public void generateDocument(){
        try {
            Document document = new Document();

            //Create OutputStream instance.
            OutputStream outputStream =
                    new FileOutputStream(new File("C:\\Result\\TestFile.pdf"));

            //Create PDFWriter instance.
            PdfWriter.getInstance(document, outputStream);

            //Open the document.
            document.open();

            //Add content to the document.
            document.add(new Paragraph("Hello world, " +
                    "this is a test pdf file."));

            //Close document and outputStream.
            document.close();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
