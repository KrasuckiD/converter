package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CSVFileReaderTest {

    private static final String CSV_FILE_NAME = "testowycsv.csv";

    @Test
    public void TestIsReadCSVFileReader() throws IOException {
        //given

        CSVFileReader reader = new CSVFileReader();
        String filePath = getClass().getClassLoader().getResource(CSV_FILE_NAME).getPath();
        List<Book> expected = new ArrayList<>();
        Book lalka = new Book();
        lalka.setTitle("Lalka");
        lalka.setAuthor("Prus");
        lalka.setReleaseDate(1820);
        expected.add(lalka);

        //when
        List<Book> result = reader.read(filePath);

        //them
        Assert.assertEquals(expected,result);
    }

}