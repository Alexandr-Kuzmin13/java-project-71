package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.LinkedHashMap;

public class Formatter {
    public static String formatter(LinkedHashMap<String, Object> result, String format) throws JsonProcessingException {

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
