package pl.sda;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExelFileWriter implements SDAFileWriter {

    @Override
    public void write(List<Book> records, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Books");

        int rowCount = 0;
        Row headerRow = sheet.createRow(rowCount++);

        String[] headers = new String[]{"title", "author", "releaseDate"};

        int cellCount = 0;

        for (String header : headers) {
            Cell cell = headerRow.createCell(cellCount++);
            cell.setCellValue(header);
        }
        for (Book book : records) {
            cellCount = 0;
            Row row = sheet.createRow(rowCount++);
            Cell cellTitle = row.createCell(cellCount++);
            cellTitle.setCellValue(book.getTitle());

            Cell cellAuthor = row.createCell(cellCount++);
            cellAuthor.setCellValue(book.getAuthor());

            Cell cellReleaseDate = row.createCell(cellCount++);
            cellReleaseDate.setCellValue(book.getReleaseDate());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("nie znaleziono pliku");
        }
    }
}
