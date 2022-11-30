package hexlet.code;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeSet;

public class DiffBuilder {

    public static LinkedHashMap<String, DifferValue>
        getDiff(HashMap<String, Object> data1, HashMap<String, Object> data2) {
        LinkedHashMap<String, DifferValue> result = new LinkedHashMap<>();

        TreeSet<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key: keys) {

            if (!data1.containsKey(key)) {
                result.put(key, new DifferValue("add", data2.get(key)));
            } else if (!data2.containsKey(key)) {
                result.put(key, new DifferValue("delete", data1.get(key)));
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                result.put(key, new DifferValue("unchanged", data1.get(key)));
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                result.put(key, new DifferValue("changed", data1.get(key), data2.get(key)));
            }
        }
        return result;
    }
}
