package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DifferValue;
import java.util.LinkedHashMap;
import java.util.Map;

public class Json {
    public static String json(LinkedHashMap<String, DifferValue> resultMap) throws JsonProcessingException {

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        for (Map.Entry<String, DifferValue> resultElement: resultMap.entrySet()) {

            var getKeyElement = resultElement.getKey();
            var getKeyIndexNull = resultElement.getValue().getStatus();
            var getKeyIndexOne = resultElement.getValue().getValueOne();
            var getKeyIndexTwo = resultElement.getValue().getValueTwo();
            switch (getKeyIndexNull) {
                case "changed" -> {
                    result.put("- " + getKeyElement, getKeyIndexOne);
                    result.put("+ " + getKeyElement, getKeyIndexTwo);
                }
                case "unchanged" -> result.put("  " + getKeyElement, getKeyIndexOne);
                case "delete" -> result.put("- " + getKeyElement, getKeyIndexOne);
                case "add" -> result.put("+ " + getKeyElement, getKeyIndexOne);
                default -> throw new IllegalStateException("Unexpected value: " + getKeyIndexNull);
            }
        }

        ObjectMapper mapperJson = new ObjectMapper();

        return mapperJson.writerWithDefaultPrettyPrinter().writeValueAsString(result);

    }
}
