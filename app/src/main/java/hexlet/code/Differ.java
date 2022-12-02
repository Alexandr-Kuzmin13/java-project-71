package hexlet.code;

import hexlet.code.formatters.Formatter;
import hexlet.code.parsers.DataSupplier;

import java.io.IOException;
import java.util.HashMap;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {

        HashMap<String, Object> data1 = DataSupplier.getData(filepath1);
        HashMap<String, Object> data2 = DataSupplier.getData(filepath2);

        var result = DiffBuilder.getDiff(data1, data2);

        return Formatter.format(result, format);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {

        return generate(filepath1, filepath2, "stylish");
    }
}
