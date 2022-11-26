package hexlet.code;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test
    public void testOneJson() throws Exception {

        var actual = Differ.generate("file1.json", "file2.json", "stylish");

        var expected = ParserFactory.writerContent("stylishFile1File2.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testOneYml() throws Exception {

        var actual = Differ.generate("file1.yml", "file2.yml", "stylish");

        var expected = ParserFactory.writerContent("stylishFile1File2.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testTwoJson() throws Exception {

        var actual = Differ.generate("file3.json", "file4.json", "stylish");

        var expected = ParserFactory.writerContent("stylishFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testTwoYml() throws Exception {

        var actual = Differ.generate("file3.yml", "file4.yml", "stylish");

        var expected = ParserFactory.writerContent("stylishFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testThreeJson() throws Exception {

        var actual = Differ.generate("file3.json", "file4.json", "plain");

        var expected = ParserFactory.writerContent("plainFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testThreeYml() throws Exception {

        var actual = Differ.generate("file3.yml", "file4.yml", "plain");

        var expected = ParserFactory.writerContent("plainFile3File4.txt");

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testFourJson() throws Exception {

        var actual = Differ.generate("file3.json", "file4.json", "json");

        var expected = ParserFactory.writerContent("jsonFile3File4.json");

        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }
    @Test
    public void testFourYml() throws Exception {

        var actual = Differ.generate("file3.yml", "file4.yml", "json");

        var expected = ParserFactory.writerContent("jsonFile3File4.json");

        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }

}
