package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.Map;

public class Stylish {
    public static String stylish(LinkedHashMap<String, Object> result) {

        StringBuilder s = new StringBuilder();

        for (Map.Entry<String, Object> resultElement: result.entrySet()) {
            s.append("  ")
                    .append(resultElement.getKey())
                    .append(": ")
                    .append(resultElement.getValue())
                    .append("\n");
        }

        return "{\n" + s + "}";
    }
}
