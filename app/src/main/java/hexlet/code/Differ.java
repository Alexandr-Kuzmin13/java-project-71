package hexlet.code;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {

        HashMap<String, Object> data1 = Parser.parsing(filepath1);
        HashMap<String, Object> data2 = Parser.parsing(filepath2);
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        assert data1 != null;
        TreeSet<String> keys = new TreeSet<>(data1.keySet());
        assert data2 != null;
        keys.addAll(data2.keySet());

        for (String key: keys) {

            if (!data1.containsKey(key)) {
                result.put("+ " + key, data2.get(key));
            } else if (!data2.containsKey(key)) {
                result.put("- " + key, data1.get(key));
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                result.put("  " + key, data1.get(key));
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                result.put("- " + key, data1.get(key));
                result.put("+ " + key, data2.get(key));
            }
        }

        return Formatter.formatter(result, format);

    }
    public static String generate(String filepath1, String filepath2) throws IOException {

        HashMap<String, Object> data1 = Parser.parsing(filepath1);
        HashMap<String, Object> data2 = Parser.parsing(filepath2);
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();

        assert data1 != null;
        TreeSet<String> keys = new TreeSet<>(data1.keySet());
        assert data2 != null;
        keys.addAll(data2.keySet());

        for (String key: keys) {

            if (!data1.containsKey(key)) {
                result.put("+ " + key, data2.get(key));
            } else if (!data2.containsKey(key)) {
                result.put("- " + key, data1.get(key));
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                result.put("  " + key, data1.get(key));
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                result.put("- " + key, data1.get(key));
                result.put("+ " + key, data2.get(key));
            }
        }

        return Formatter.formatter(result, "stylish");

    }
}
