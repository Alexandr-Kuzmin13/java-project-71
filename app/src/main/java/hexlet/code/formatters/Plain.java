package hexlet.code.formatters;

import hexlet.code.DifferValue;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(LinkedHashMap<String, DifferValue> resultMap) {

        StringBuilder textResult = new StringBuilder();

        for (Map.Entry<String, DifferValue> resultElement: resultMap.entrySet()) {

            var key = resultElement.getKey();
            var value = resultElement.getValue();
            var status = value.getStatus();
            var value1 = normalize(value.getValueOne());
            var value2 = normalize(value.getValueTwo());
            switch (status) {
                case "changed" -> textResult.append(String.format("Property '%s' was updated. From %s to %s\n",
                        key, value1, value2));
                case "unchanged" -> {
                }
                case "delete" -> textResult.append(String.format("Property '%s' was removed\n", key));
                case "add" -> textResult.append(String.format("Property '%s' was added with value: %s\n",
                        key, value1));
                default -> throw new RuntimeException("Unexpected value: " + status);
            }
        }
        return textResult.toString().replaceAll("\\R$", "");
    }

    public static String normalize(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        return "" + value + "";
    }
}
