package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

import static java.nio.file.Files.readString;

public class Differ {

    public static String generate(Path filepath1, Path filepath2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> data1 = mapper.readValue(readString(filepath1), new TypeReference<>() { });
        HashMap<String, Object> data2 = mapper.readValue(readString(filepath2), new TypeReference<>() { });

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        TreeSet<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key: keys) {

            if (!data1.containsKey(key)) {
                result.put("+ " + key, data2.get(key));
            } else if (!data2.containsKey(key)) {
                result.put("- " + key, data1.get(key));
            } else if (data1.get(key).equals(data2.get(key))) {
                result.put(key, data1.get(key));
            } else if (!data1.get(key).equals(data2.get(key))) {
                result.put("- " + key, data1.get(key));
                result.put("+ " + key, data2.get(key));
            }
        }
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, Object> resultElement: result.entrySet()) {
            s.append(resultElement.getKey()).append(": ").append(resultElement.getValue().toString()).append("\n");
        }
        return "{\n" + s + "}";
    }
}
