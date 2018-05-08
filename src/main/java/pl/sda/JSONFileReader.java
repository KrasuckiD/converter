package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONFileReader implements SDAFileReader {

    @Override
    public List<Book> read(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));

        String json = new String(bytes, "UTF-8");

        JSONObject jsonObject = new JSONObject(json);

        String rootKey = jsonObject.keySet().iterator().next();

        JSONArray rawValues = new JSONArray(jsonObject.get(rootKey).toString());

        for (Object rawValue : rawValues) {
            JSONObject value = new JSONObject(rawValue.toString());
            String title = value.get("title").toString();
            String author = value.get("author").toString();
            Integer releaseDate = Integer.parseInt(value.get("releaseDate").toString());

            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setReleaseDate(releaseDate);

            books.add(book);
        }

        return books;
    }
}
