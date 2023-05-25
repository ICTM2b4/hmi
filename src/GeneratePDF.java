import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class GeneratePDF {

/* gerenratePDF file */
    public static void generatePDF() {

        try {
            // Create Document instance.
            Document document = new Document();

            SelectFileLocation fileLocation = new SelectFileLocation(Order.selectOrder.getOrderNumber() + "");
            if (fileLocation.getFileSelected()) {
                String fileLocationString = fileLocation.getFileLocation();
                // Create OutputStream instance.
                OutputStream outputStream = new FileOutputStream(new File(fileLocationString + ".pdf"));

                // Create PDFWriter instance.
                PdfWriter.getInstance(document, outputStream);

                // Open the document.
                // Add content to the document.
                document.open();
                PdfPTable pdfPTable2 = new PdfPTable(new float[] { 14, 30 });
                // Create cells
                PdfPCell pdfPCellcatogory = new PdfPCell(new Paragraph("Ordernummer:"));
                PdfPCell pdfPCelldata = new PdfPCell(new Paragraph(" " + Order.selectOrder.getOrderNumber()));
                pdfPCelldata.setBorderWidth(0);
                pdfPCellcatogory.setBorderWidth(0);
                pdfPTable2.addCell(pdfPCellcatogory);
                pdfPTable2.addCell(pdfPCelldata);

                pdfPCellcatogory = new PdfPCell(new Paragraph("Naam:"));
                pdfPCelldata = new PdfPCell(new Paragraph(" " + Order.selectOrder.getCustomer().getName()));
                pdfPCelldata.setBorderWidth(0);
                pdfPCellcatogory.setBorderWidth(0);
                pdfPTable2.addCell(pdfPCellcatogory);
                pdfPTable2.addCell(pdfPCelldata);

                pdfPCellcatogory = new PdfPCell(new Paragraph("Adres:"));
                pdfPCelldata = new PdfPCell(new Paragraph(" " + Order.selectOrder.getCustomer().getAddress()));
                pdfPCelldata.setBorderWidth(0);
                pdfPCellcatogory.setBorderWidth(0);
                pdfPTable2.addCell(pdfPCellcatogory);
                pdfPTable2.addCell(pdfPCelldata);

                pdfPCellcatogory = new PdfPCell(new Paragraph("E-mail:"));
                pdfPCelldata = new PdfPCell(new Paragraph(" " + Order.selectOrder.getCustomer().getEmail()));
                pdfPCelldata.setBorderWidth(0);
                pdfPCellcatogory.setBorderWidth(0);
                pdfPTable2.addCell(pdfPCellcatogory);
                pdfPTable2.addCell(pdfPCelldata);

                pdfPCellcatogory = new PdfPCell(new Paragraph("Telefoon:"));
                pdfPCelldata = new PdfPCell(new Paragraph(" " + Order.selectOrder.getCustomer().getPhoneNumber()));
                pdfPCelldata.setBorderWidth(0);
                pdfPCellcatogory.setBorderWidth(0);
                pdfPTable2.addCell(pdfPCellcatogory);
                pdfPTable2.addCell(pdfPCelldata);

                pdfPTable2.setWidthPercentage(50);
                pdfPTable2.setHorizontalAlignment(0);

                document.add(pdfPTable2);


                PdfPTable pdfPTable = new PdfPTable(new float[] { 75, 25 });
                // Create cells
                PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Productnaam"));
                PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Aantal"));
                // Add cells to table
                pdfPTable.addCell(pdfPCell1);
                pdfPTable.addCell(pdfPCell2);
                ArrayList<Product> products = Order.selectOrder.getProducts();
                for (Product product : products) {
                    pdfPTable.addCell(product.getName());
                    pdfPTable.addCell(String.valueOf(product.getAmount()));
                }
                document.add(new Paragraph(" "));
                document.add(pdfPTable);

                // Close document and outputStream.
                document.close();
                outputStream.close();

                System.out.println("Pdf created successfully.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pdf failed to create.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return;
    }
}
