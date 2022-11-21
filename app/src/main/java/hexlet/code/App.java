package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<String> {

    @Parameters(index = "0", description = "path to first file", defaultValue = "file3.json")
    private final File file1 = new File("mnt/c/rusglagol/java-project-71/app");

    @Parameters(index = "1", description = "path to second file", defaultValue = "file4.json")
    private final File file2 = new File("mnt/c/rusglagol/java-project-71/app");

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]", defaultValue = "stylish")
    private String format;
    @Override
    public String call() throws Exception {
        var filepath1 = file1.toPath().toString();
        var filepath2 = file2.toPath().toString();

        var diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }


}
