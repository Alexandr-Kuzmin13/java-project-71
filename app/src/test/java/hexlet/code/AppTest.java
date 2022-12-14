package hexlet.code;

import hexlet.code.parsers.DataSupplier;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test
    public void testOneJson() throws Exception {

        var actual = Differ.generate("resources/file1.json", "resources/file2.json", "stylish");

        var expected = DataSupplier.getContent("resources/stylishFile1File2.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testOneYml() throws Exception {

        var actual = Differ.generate("resources/file1.yml", "resources/file2.yml", "stylish");

        var expected = DataSupplier.getContent("resources/stylishFile1File2.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testTwoJson() throws Exception {

        var actual = Differ.generate("resources/file3.json", "resources/file4.json", "stylish");

        var expected = DataSupplier.getContent("resources/stylishFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testTwoYml() throws Exception {

        var actual = Differ.generate("resources/file3.yml", "resources/file4.yml", "stylish");

        var expected = DataSupplier.getContent("resources/stylishFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testThreeJson() throws Exception {

        var actual = Differ.generate("resources/file3.json", "resources/file4.json", "plain");

        var expected = DataSupplier.getContent("resources/plainFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testThreeYml() throws Exception {

        var actual = Differ.generate("resources/file3.yml", "resources/file4.yml", "plain");

        var expected = DataSupplier.getContent("resources/plainFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testFourJson() throws Exception {

        var actual = Differ.generate("resources/file3.json", "resources/file4.json", "json");

        var expected = DataSupplier.getContent("resources/jsonFile3File4Map.json");

        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }
    @Test
    public void testFourYml() throws Exception {

        var actual = Differ.generate("resources/file3.yml", "resources/file4.yml", "json");

        var expected = DataSupplier.getContent("resources/jsonFile3File4Map.json");

        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }

}
