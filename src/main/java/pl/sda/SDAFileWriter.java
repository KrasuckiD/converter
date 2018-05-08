package pl.sda;

import java.io.IOException;
import java.util.List;

public interface SDAFileWriter {
    public void write(List<Book> records, String filePath) throws IOException;
}
