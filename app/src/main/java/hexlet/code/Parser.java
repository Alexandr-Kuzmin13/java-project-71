package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;

public interface Parser {

    HashMap<String, Object> parse() throws JsonProcessingException;

}
