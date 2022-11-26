package hexlet.code.formatters;

import hexlet.code.DifferValue;
import java.util.LinkedHashMap;
import java.util.Map;

public class Stylish {
    public static String stylish(LinkedHashMap<String, DifferValue> result) {

        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append("{\n");

        for (Map.Entry<String, DifferValue> resultElement: result.entrySet()) {

            var getKeyElement = resultElement.getKey();
            var getKeyIndexNull = resultElement.getValue().getStatus();
            var getKeyIndexOne = resultElement.getValue().getValueOne();
            var getKeyIndexTwo = resultElement.getValue().getValueTwo();
            switch (getKeyIndexNull) {
                case "changed" -> {
                    resultBuilder.append(String.format("  - %s: %s\n", getKeyElement, getKeyIndexOne));
                    resultBuilder.append(String.format("  + %s: %s\n", getKeyElement, getKeyIndexTwo));
                }
                case "unchanged" -> resultBuilder.append(String.format("    %s: %s\n", getKeyElement, getKeyIndexOne));
                case "delete" -> resultBuilder.append(String.format("  - %s: %s\n", getKeyElement, getKeyIndexOne));
                case "add" -> resultBuilder.append(String.format("  + %s: %s\n", getKeyElement, getKeyIndexOne));
                default -> throw new IllegalStateException("Unexpected value: " + getKeyIndexNull);
            }
        }
        resultBuilder.append("}");

        return resultBuilder.toString().replaceAll("\\R$", "");
    }
}
