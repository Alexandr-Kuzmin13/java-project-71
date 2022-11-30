package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public final class JsonParser implements Parser {

    @Override
    public HashMap<String, Object> parse(String content) throws JsonProcessingException {
        ObjectMapper mapperJson = new ObjectMapper();
        return mapperJson.readValue(content, new TypeReference<>() { });
    }

}
