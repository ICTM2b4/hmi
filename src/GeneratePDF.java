import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class GeneratePDF {

public static void generatePDF() {

    try {
        //Create Document instance.
        Document document = new Document();

        //Create OutputStream instance.
        OutputStream outputStream =
                new FileOutputStream(new File("C:\\\\Users\\\\tygov\\\\Downloads\\"+ Order.selectOrder.getOrderNumber() + ".pdf"));

        //Create PDFWriter instance.
        PdfWriter.getInstance(document, outputStream);

        //Open the document.
        // Add content to the document.
        document.open();
        int[] columnWidths = {1, 5, 5};
        document.add(new Paragraph("Ordernummer: " + Order.selectOrder.getOrderNumber()));
         document.add(new Paragraph("Naam: " + Order.selectOrder.getCustomer().getName()));
            document.add(new Paragraph("Adres: " + Order.selectOrder.getCustomer().getAddress()));
            document.add(new Paragraph("E-mail: " + Order.selectOrder.getCustomer().getEmail()));
            document.add(new Paragraph("Telefoon: " + Order.selectOrder.getCustomer().getPhoneNumber()));
        document.add(new Paragraph(" "));
        PdfPTable pdfPTable = new PdfPTable(new float[] { 75,25 }) ;
        //Create cells
        PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Productnaam"));
        PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Aantal"));


        //Add cells to table
        pdfPTable.addCell(pdfPCell1);
        pdfPTable.addCell(pdfPCell2);


        document.add(pdfPTable);


        //Close document and outputStream.
        document.close();
        outputStream.close();

        System.out.println("Pdf created successfully.");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return;
}
}
