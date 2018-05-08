package pl.sda;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JSONFileReaderTest {


    @Test
    public void readerTest() throws IOException {
        //given
        String filePath = "C:\\Users\\Dell\\Desktop\\projekty\\converter\\src\\test\\resources\\books.json";
        JSONFileReader reader = new JSONFileReader();
        List<Book> expected = new ArrayList<>();
        Book book = new Book();
        Book book2 = new Book();

        book.setTitle("Jan");
        book.setAuthor("Nowak");
        book.setReleaseDate(20);

        book2.setTitle("Pan");
        book2.setAuthor("Tadeusz");
        book2.setReleaseDate(15);

        expected.add(book);
        expected.add(book2);

        //when
        List<Book> result = reader.read(filePath);
        //them
        Assert.assertEquals(expected,result);
    }

}