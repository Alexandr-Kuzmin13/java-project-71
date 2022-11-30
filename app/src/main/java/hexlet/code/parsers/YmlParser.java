package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.HashMap;

public final class YmlParser implements Parser {

    @Override
    public HashMap<String, Object> parse(String content) throws JsonProcessingException {
        ObjectMapper mapperYml = new ObjectMapper(new YAMLFactory());
        return mapperYml.readValue(content, new TypeReference<>() { });
    }
}
