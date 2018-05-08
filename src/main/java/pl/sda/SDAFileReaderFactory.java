package pl.sda;

public class SDAFileReaderFactory {
    public static SDAFileReader produce(String filePath) {
        SDAFileReader result = null;

        if (filePath.toLowerCase().endsWith(".csv")) {
            result = new CSVFileReader();
        } else if (filePath.toLowerCase().endsWith(".json")) {
            result = new JSONFileReader();
        } else if (filePath.toLowerCase().endsWith(".xlsx")) {
            result = new ExelFileReader();
        }

        return result;
    }
}
