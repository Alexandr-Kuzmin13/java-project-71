package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public final class JsonParser implements Parser {

    private final String content;
    public JsonParser(String jsonContent) {
        this.content = jsonContent;
    }

    @Override
    public HashMap<String, Object> parse() throws JsonProcessingException {
        ObjectMapper mapperJson = new ObjectMapper();
        return mapperJson.readValue(content, new TypeReference<>() { });
    }

}
