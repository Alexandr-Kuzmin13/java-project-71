package hexlet.code.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;

public interface Parser {

    HashMap<String, Object> parse(String content) throws JsonProcessingException;

}
