package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import static org.assertj.core.api.Assertions.assertThat;
class AppTest {
    @Test
    public void testOne() throws Exception {
        //File result1 = new File("mnt/c/rusglagol/java-project-71/app/src/test/resources/file1.json");
        //File result2 = new File("mnt/c/rusglagol/java-project-71/app/src/test/resources/file2.json");
        File result1 = new File("file1.json");
        File result2 = new File("file2.json");
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
