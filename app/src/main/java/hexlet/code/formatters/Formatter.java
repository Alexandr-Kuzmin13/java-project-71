package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.DifferValue;
import java.util.LinkedHashMap;

public class Formatter {
    public static String format(LinkedHashMap<String, DifferValue> result, String format)
            throws JsonProcessingException {

        switch (format) {
            case "stylish" -> {
                return Stylish.stylish(result);
            }
            case "plain" -> {
                return Plain.plain(result);
            }
            case "json" -> {
                return Json.json(result);
            }
            default -> throw new IllegalStateException("Unexpected value: " + format);
        }
    }
}
