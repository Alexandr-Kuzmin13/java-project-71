package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;

import static java.nio.file.Files.readString;
import static org.assertj.core.api.Assertions.assertThat;
class AppTest {
    @Test
    public void testOne() throws Exception {
        var file1 = new File("file1.json");
        var file2 = new File("file2.json");
        var result1 = readString(file1.toPath());
        var result2 = readString(file2.toPath());
        var actual = Differ.generate(result1, result2);
        var expected = """
                {
                - follow: false
                host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true
                }""";
        assertThat(actual).isEqualTo(expected);
    }
}
