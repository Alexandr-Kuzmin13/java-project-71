package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Callable;

import static java.nio.file.Files.readString;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<String> {

    @Parameters(index = "0", description = "path to first file", defaultValue = "file1.json")
    private final File filepath1 = new File("mnt/c/rusglagol/java-project-71/app");

    @Parameters(index = "1", description = "path to second file", defaultValue = "file2.json")
    private final File filepath2 = new File("mnt/c/rusglagol/java-project-71/app");

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;

    @Override
    public String call() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> result1 = mapper.readValue(readString(filepath1.toPath()), new TypeReference<>() { });
        HashMap<String, Object> result2 = mapper.readValue(readString(filepath2.toPath()), new TypeReference<>() { });
        var diff = Differ.generate(result1, result2);
        System.out.println(diff);
        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }


}
