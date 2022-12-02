package hexlet.code.formatters;

import hexlet.code.DifferValue;
import java.util.LinkedHashMap;
import java.util.Map;

public class Stylish {
    public static String stylish(LinkedHashMap<String, DifferValue> resultMap) {

        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append("{\n");

        for (Map.Entry<String, DifferValue> resultElement: resultMap.entrySet()) {

            var key = resultElement.getKey();
            var value = resultElement.getValue();
            var status = value.getStatus();
            var value1 = value.getValueOne();
            var value2 = value.getValueTwo();
            switch (status) {
                case "changed" -> {
                    resultBuilder.append(String.format("  - %s: %s\n", key, value1));
                    resultBuilder.append(String.format("  + %s: %s\n", key, value2));
                }
                case "unchanged" -> resultBuilder.append(String.format("    %s: %s\n", key, value1));
                case "delete" -> resultBuilder.append(String.format("  - %s: %s\n", key, value1));
                case "add" -> resultBuilder.append(String.format("  + %s: %s\n", key, value1));
                default -> throw new RuntimeException("Unexpected value: " + status);
            }
        }

        resultBuilder.append("}");

        return resultBuilder.toString().replaceAll("\\R$", "");
    }
}
