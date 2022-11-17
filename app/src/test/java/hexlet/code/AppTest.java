package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
class AppTest {
    @Test
    public void testOne() throws Exception {
        Path result1 = Path.of("file1.json");
        Path result2 = Path.of("file2.json");
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
