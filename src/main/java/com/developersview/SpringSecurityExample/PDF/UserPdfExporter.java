package com.developersview.SpringSecurityExample.PDF;

import com.developersview.SpringSecurityExample.Dao.User;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * @author pranoy.chakraborty
 * @Date 07/08/22
 */
public class UserPdfExporter {
    private List<User> userList;

    public UserPdfExporter(List<User> userList) {
        this.userList = userList;
    }

    private void writeTableHeader(PdfPTable table){
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.CYAN);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);
        font.setSize(12);
        cell.setPhrase(new Phrase("User ID",font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("First Name",font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Last Name",font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email ID",font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Password",font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table){
        for(User user:userList){
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getFirstName());
            table.addCell(user.getLastName());
            table.addCell(user.getEmail());
            table.addCell(user.getPassword());
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(20);
        font.setStyle(Font.BOLD);
        font.setColor(Color.BLACK);
        Paragraph paragraph = new Paragraph("List of Users");
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);
        document.close();
    }
}
