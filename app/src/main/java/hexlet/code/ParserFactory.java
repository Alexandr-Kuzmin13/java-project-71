package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ParserFactory {
    public static HashMap<String, Object> getParser(String filepath) throws IOException {

        String content = writerContent(filepath);

        if (filepath.endsWith("json")) {
            return runParser(new JsonParser(content));
        } else if (filepath.endsWith("yml")) {
            return runParser(new YmlParser(content));
        }
        return null;
    }
    public static String writerContent(String filepath) throws IOException {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
    public static HashMap<String, Object> runParser(Parser parser) throws JsonProcessingException {
        return parser.parse();
    }
}
