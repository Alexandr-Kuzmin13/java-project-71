package hexlet.code.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class DataSupplier {
    public static HashMap<String, Object> getData(String filepath) throws IOException {

        String content = getContent(filepath);

        Parser parser = ParserFactory.getParser(getExtension(filepath));

        return parser.parse(content);
    }
    public static String getContent(String filepath) throws IOException {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
    public static String getExtension(String filepath) {

        return filepath.substring(filepath.indexOf("."));
    }
}
