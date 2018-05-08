package pl.sda;

import java.util.List;

public interface SDAFileWriter {
    public void write(List<Book> records, String filePath);
}
