package pl.sda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\Dell\\Desktop\\projekty\\converter\\src\\test\\resources\\testowycsv.csv";
        SDAFileReader reader = SDAFileReaderFactory.produce(filePath);

        String exelFilePath = "C:\\Users\\Dell\\Desktop\\projekty\\converter\\src\\test\\resources\\example.xlsx";
        SDAFileWriter writer = SDAFileWriterFactory.produce(exelFilePath);

        List<Book> books = reader.read(filePath);
        writer.write(books,exelFilePath);
    }
}
