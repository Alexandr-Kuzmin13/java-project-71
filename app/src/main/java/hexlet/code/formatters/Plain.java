package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(LinkedHashMap<String, Object> result) {

        StringBuilder s = new StringBuilder();

        for (Map.Entry<String, Object> resultElement: result.entrySet()) {
            if (resultElement.getValue() != null) {
                if (resultElement.getValue() instanceof String) {
                    resultElement.setValue("'" + resultElement.getValue() + "'");
                }
                if (resultElement.getValue() instanceof Map || resultElement.getValue() instanceof List) {
                    resultElement.setValue("[complex value]");
                }
            }
        }
        for (Map.Entry<String, Object> resultElement: result.entrySet()) {
            var elementReplaceDeleteAdd = resultElement.getKey().replace("-", "+");
            var elementReplaceAddDelete = resultElement.getKey().replace("+", "-");
            if (resultElement.getKey().charAt(0) == '-' && result.containsKey(elementReplaceDeleteAdd)) {
                s.append("Property '")
                        .append(resultElement.getKey().substring(2))
                        .append("' was updated. From ")
                        .append(resultElement.getValue())
                        .append(" to ")
                        .append(result.get(resultElement.getKey().replace("-", "+")))
                        .append("\n");
            } else if (resultElement.getKey().charAt(0) == '-' && !result.containsKey(elementReplaceDeleteAdd)) {
                s.append("Property '")
                        .append(resultElement.getKey().substring(2))
                        .append("' was removed")
                        .append("\n");
            } else if (resultElement.getKey().charAt(0) == '+' && !result.containsKey(elementReplaceAddDelete)) {
                s.append("Property '")
                        .append(resultElement.getKey().substring(2))
                        .append("' was added with value: ")
                        .append(resultElement.getValue())
                        .append("\n");
            }

        }

        return s.toString().replaceAll("\\R$", "");
    }
}
