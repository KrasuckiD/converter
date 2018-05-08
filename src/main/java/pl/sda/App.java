package pl.sda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

//        String originFilePath = "C:\\Users\\Dell\\Desktop\\projekty\\books.csv";
//        String destinationFilePath = "C:\\Users\\Dell\\Desktop\\projekty\\example.pdf";
//
//
//        SDAFileReader reader = SDAFileReaderFactory.produce(originFilePath);
//        SDAFileWriter writer = SDAFileWriterFactory.produce(destinationFilePath);
//
//        List<Book> values = reader.read(originFilePath);
//        writer.write(values, destinationFilePath);

        String filePath = "C:\\Users\\Dell\\Desktop\\projekty\\converter\\src\\test\\resources\\books.xlsx";
        SDAFileReader reader = SDAFileReaderFactory.produce(filePath);
        List<Book> books = reader.read(filePath);
        System.out.println(books);
    }
}
