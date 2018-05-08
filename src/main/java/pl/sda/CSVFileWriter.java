package pl.sda;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileWriter implements SDAFileWriter {

    @Override
    public void write(List<Book> records, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            String header = "title;author;releaseDate"+ "\r\n";
            bufferedWriter.write(header);

            String line ="";

            for (Book book: records) {
                line = book.getTitle() + ";" + book.getAuthor() + ";" + book.getReleaseDate() + ";"+ "\r\n";
                bufferedWriter.write(line);
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Wystapil blad");
        }
    }


}
