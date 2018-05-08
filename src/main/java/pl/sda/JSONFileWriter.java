package pl.sda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONFileWriter implements SDAFileWriter {
    @Override
    public void write(List<Book> records, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            JSONArray jsonArray = new JSONArray();
            for (Book book : records) {
                JSONObject bookJSON = new JSONObject();
                bookJSON.put("title", book.getTitle());
                bookJSON.put("author", book.getAuthor());
                bookJSON.put("releaseDate", book.getReleaseDate());
                jsonArray.put(bookJSON);
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("books", jsonArray);

            bufferedWriter.write(jsonObject.toString());

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
