package hexlet.code.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ParserFactory {
    public static HashMap<String, Object> getParser(String filepath) throws IOException {

        String content = ParserFactory.getContent(filepath);

        Parser parser;

        if (filepath.endsWith("json")) {
            parser = new JsonParser();
        } else if (filepath.endsWith("yml")) {
            parser = new YmlParser();
        } else {
            throw new IOException("parser can not be null!");
        }

        return DataSupplier.dataSupplier(parser, content);
    }
    public static String getContent(String filepath) throws IOException {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
