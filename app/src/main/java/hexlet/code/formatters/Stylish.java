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
            var keyIndexNull = value.getStatus();
            var keyIndexOne = value.getValueOne();
            var keyIndexTwo = value.getValueTwo();
            switch (keyIndexNull) {
                case "changed" -> {
                    resultBuilder.append(String.format("  - %s: %s\n", key, keyIndexOne));
                    resultBuilder.append(String.format("  + %s: %s\n", key, keyIndexTwo));
                }
                case "unchanged" -> resultBuilder.append(String.format("    %s: %s\n", key, keyIndexOne));
                case "delete" -> resultBuilder.append(String.format("  - %s: %s\n", key, keyIndexOne));
                case "add" -> resultBuilder.append(String.format("  + %s: %s\n", key, keyIndexOne));
                default -> throw new RuntimeException("Unexpected value: " + keyIndexNull);
            }
        }

        resultBuilder.append("}");

        return resultBuilder.toString().replaceAll("\\R$", "");
    }
}
