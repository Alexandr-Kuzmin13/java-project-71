package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DifferValue;
import java.util.LinkedHashMap;

public class Json {
    public static String json(LinkedHashMap<String, DifferValue> resultMap) throws JsonProcessingException {

        ObjectMapper mapperJson = new ObjectMapper();

        return mapperJson.writeValueAsString(resultMap);

    }
}
