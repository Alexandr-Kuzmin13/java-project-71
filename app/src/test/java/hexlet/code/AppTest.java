package hexlet.code;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
class AppTest {
    @Test
    public void testOneJson() throws Exception {
        var file1 = new File("file1.json");
        var file2 = new File("file2.json");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "stylish");
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
    @Test
    public void testOneYml() throws Exception {
        var file1 = new File("file1.yml");
        var file2 = new File("file2.yml");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "stylish");
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
    @Test
    public void testTwoJson() throws Exception {
        var file1 = new File("file3.json");
        var file2 = new File("file4.json");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "stylish");
        var expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testTwoYml() throws Exception {
        var file1 = new File("file3.yml");
        var file2 = new File("file4.yml");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "stylish");
        var expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testThreeJson() throws Exception {
        var file1 = new File("file3.json");
        var file2 = new File("file4.json");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "plain");
        var expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testThreeYml() throws Exception {
        var file1 = new File("file3.yml");
        var file2 = new File("file4.yml");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "plain");
        var expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void testFourJson() throws Exception {
        var file1 = new File("file3.json");
        var file2 = new File("file4.json");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "json");
        var expected = """
              {
                  "  chars1" : [ "a", "b", "c" ],
                  "- chars2" : [ "d", "e", "f" ],
                  "+ chars2" : false,
                  "- checked" : false,
                  "+ checked" : true,
                  "- default" : null,
                  "+ default" : [ "value1", "value2" ],
                  "- id" : 45,
                  "+ id" : null,
                  "- key1" : "value1",
                  "+ key2" : "value2",
                  "  numbers1" : [ 1, 2, 3, 4 ],
                  "- numbers2" : [ 2, 3, 4, 5 ],
                  "+ numbers2" : [ 22, 33, 44, 55 ],
                  "- numbers3" : [ 3, 4, 5 ],
                  "+ numbers4" : [ 4, 5, 6 ],
                  "+ obj1" : {
                    "nestedKey" : "value",
                    "isNested" : true
                  },
                  "- setting1" : "Some value",
                  "+ setting1" : "Another value",
                  "- setting2" : 200,
                  "+ setting2" : 300,
                  "- setting3" : true,
                  "+ setting3" : "none"
                }""";
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }
    @Test
    public void testFourYml() throws Exception {
        var file1 = new File("file3.yml");
        var file2 = new File("file4.yml");
        var result1 = file1.toPath().toString();
        var result2 = file2.toPath().toString();
        var actual = Differ.generate(result1, result2, "json");
        var expected = """
              {
                  "  chars1" : [ "a", "b", "c" ],
                  "- chars2" : [ "d", "e", "f" ],
                  "+ chars2" : false,
                  "- checked" : false,
                  "+ checked" : true,
                  "- default" : null,
                  "+ default" : [ "value1", "value2" ],
                  "- id" : 45,
                  "+ id" : null,
                  "- key1" : "value1",
                  "+ key2" : "value2",
                  "  numbers1" : [ 1, 2, 3, 4 ],
                  "- numbers2" : [ 2, 3, 4, 5 ],
                  "+ numbers2" : [ 22, 33, 44, 55 ],
                  "- numbers3" : [ 3, 4, 5 ],
                  "+ numbers4" : [ 4, 5, 6 ],
                  "+ obj1" : {
                    "nestedKey" : "value",
                    "isNested" : true
                  },
                  "- setting1" : "Some value",
                  "+ setting1" : "Another value",
                  "- setting2" : 200,
                  "+ setting2" : 300,
                  "- setting3" : true,
                  "+ setting3" : "none"
                }""";
        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT);
    }

}
