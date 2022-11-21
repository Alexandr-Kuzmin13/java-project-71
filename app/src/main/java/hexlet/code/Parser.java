package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.HashMap;
import static java.nio.file.Files.readString;


public class Parser {

    public static HashMap<String, Object> parsing(String filepath) throws IOException {
        ObjectMapper mapperJson = new ObjectMapper();
        ObjectMapper mapperYml = new ObjectMapper(new YAMLFactory());
        String data = readString(FileSystems.getDefault().getPath(filepath));

        if (filepath.contains(".json")) {
            return mapperJson.readValue(data, new TypeReference<>() { });
        } else if (filepath.contains(".yml")) {
            return mapperYml.readValue(data, new TypeReference<>() { });
        }

        return null;
    }
}
