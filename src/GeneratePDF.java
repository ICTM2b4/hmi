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


                PdfPTable pdfPTableProd = new PdfPTable(new float[] { 75, 25 });
                PdfPTable pdfPTableProd2 = new PdfPTable(new float[] { 75, 25 });
                PdfPTable pdfPTableProd3 = new PdfPTable(new float[] { 75, 25 });

                // Create cells
                PdfPCell pdfPCell1 = new PdfPCell(new Paragraph("Productnaam"));
                PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Aantal"));
                // Add cells to table
                pdfPTableProd.addCell(pdfPCell1);
                pdfPTableProd.addCell(pdfPCell2);

                pdfPTableProd2.addCell(pdfPCell1);
                pdfPTableProd2.addCell(pdfPCell2);

                pdfPTableProd3.addCell(pdfPCell1);
                pdfPTableProd3.addCell(pdfPCell2);

                Boolean box1 = false;
                Boolean box2 = false;
                Boolean box3 = false;
                int total = 0;
                int counter = 0;

                ArrayList<Product> products = Order.selectOrder.getProducts();
                for (Product product : products) {
                    total = total + product.getAmount();
                    
                    //Fill boxes
                    for(int i = 0; i < product.getAmount(); i++){
                        if(!box1){
                            pdfPTableProd.addCell(product.getName());
                            pdfPTableProd.addCell("1");
                            counter++;
                            if(counter == 3){
                                box1 = true;
                                counter = 0;
                            }
                        }else if(!box2){
                            pdfPTableProd2.addCell(product.getName());
                            pdfPTableProd2.addCell("1");
                            counter++;
                            if(counter == 3){
                                box2 = true;
                                counter = 0;
                            }
                        }else if(!box3){
                            pdfPTableProd3.addCell(product.getName());
                            pdfPTableProd3.addCell("1");
                            counter++;
                            if(counter == 3){
                                box3 = true;
                                counter = 0;
                            }
                        }
                    }
                }
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Doos 1"));
                document.add(pdfPTableProd);

                if(total >= 3){
                document.add(new Paragraph("Doos 2"));
                document.add(pdfPTableProd2);
                }

                if(total >= 6){
                document.add(new Paragraph("Doos 3"));
                document.add(pdfPTableProd3);
                }

                // Close document and outputStream.
                document.close();
                outputStream.close();

                System.out.println("Pdf created successfully.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pdf niet gegegenereerd.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return;
    }
}
