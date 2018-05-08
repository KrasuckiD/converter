package pl.sda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader implements SDAFileReader {

    @Override
    public List<Book> read(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        List<Book> books = new ArrayList<>();
        String[] headers = null;

        int i = 0;

        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            if (i == 0) {
                headers = line.split(";");
                i++;
            } else {
                Book parsedBook = parseCSVRow(headers, line);
                books.add(parsedBook);
            }

        }
        return books;
    }

    private Book parseCSVRow(String[] headers, String line) {
        Book book = new Book();
        String[] values = line.split(";");

        for (int i = 0; i < headers.length; i++) {
            setBookFieldFromCSVFile(book, headers[i], values[i]);
        }
        return book;
    }

    private void setBookFieldFromCSVFile(Book book, String header, String value) {
        if ("title".equals(header)) {
            book.setTitle(value);
        }

        if ("author".equals(header)) {
            book.setAuthor(value);
        }

        if ("releaseDate".equals(header)) {
            book.setReleaseDate(Integer.parseInt(value));
        }
    }
}
