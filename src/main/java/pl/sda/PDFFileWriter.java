package pl.sda;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class PDFFileWriter implements SDAFileWriter{
    @Override
    public void write(List<Book> records, String filePath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();

        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        String header = "title;author;releaseDate"+ "\r\n";
        Chunk chunk1 = new Chunk(header, font);
        try {
            document.add(chunk1);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        String line="";
        for (Book book : records) {
            line = book.getTitle() + ";" + book.getAuthor() + ";" + book.getReleaseDate() + ";";
            Chunk chunk = new Chunk(line, font);

            try {
                document.add(chunk);
                document.add(new Phrase("\r\n"));
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }


     document.close();

    }
}
