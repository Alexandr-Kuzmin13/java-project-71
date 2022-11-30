package hexlet.code.parsers;

import java.io.IOException;
import java.util.HashMap;

public class DataSupplier {

    public static HashMap<String, Object> dataSupplier(Parser parser, String content) throws IOException {

        return parser.parse(content);
    }
}
