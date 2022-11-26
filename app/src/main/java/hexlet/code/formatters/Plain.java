package hexlet.code.formatters;

import hexlet.code.DifferValue;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(LinkedHashMap<String, DifferValue> resultMap) {

        StringBuilder textResult = new StringBuilder();

        for (Map.Entry<String, DifferValue> resultElement: resultMap.entrySet()) {

            var getKeyElement = resultElement.getKey();
            var getKeyIndexNull = resultElement.getValue().getStatus();
            var getKeyIndexOne = checkComplexValue(resultElement.getValue().getValueOne());
            var getKeyIndexTwo = checkComplexValue(resultElement.getValue().getValueTwo());
            switch (getKeyIndexNull) {
                case "changed" -> textResult.append(String.format("Property '%s' was updated. From %s to %s\n",
                        getKeyElement, getKeyIndexOne, getKeyIndexTwo));
                case "unchanged" -> {
                }
                case "delete" -> textResult.append(String.format("Property '%s' was removed\n", getKeyElement));
                case "add" -> textResult.append(String.format("Property '%s' was added with value: %s\n",
                        getKeyElement, getKeyIndexOne));
                default -> throw new IllegalStateException("Unexpected value: " + getKeyIndexNull);
            }
        }
        return textResult.toString().replaceAll("\\R$", "");
    }

    public static String checkComplexValue(Object getValue) {
        if (getValue instanceof String) {
            return "'" + getValue + "'";
        }
        if (getValue instanceof Map || getValue instanceof List) {
            return "[complex value]";
        }
        return "" + getValue + "";
    }
}
