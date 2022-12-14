package hexlet.code.parsers;

public class ParserFactory {

    public static Parser getParser(String extension) {

        switch (extension) {
            case ".json" -> {
                return new JsonParser();
            }
            case ".yml" -> {
                return new YmlParser();
            }
            default -> throw new RuntimeException("Unexpected value: " + extension);
        }
    }
}
