package pl.sda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SDAFileReader {
    List<Book> read(String filePath) throws IOException;
}
