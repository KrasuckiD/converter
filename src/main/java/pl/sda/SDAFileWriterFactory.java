package pl.sda;

public class SDAFileWriterFactory {
    public static SDAFileWriter produce(String filePath) {
        SDAFileWriter result = null;

        if (filePath.toLowerCase().endsWith(".csv")) {
            result = new CSVFileWriter();
        } else if (filePath.toLowerCase().endsWith(".pdf")) {
            result = new PDFFileWriter();
        } else if (filePath.toLowerCase().endsWith(".json")) {
            result = new JSONFileWriter();
        } else if (filePath.toLowerCase().endsWith("xlsx")) {
            result = new ExelFileWriter();
        }
        return result;

    }
}
