package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ut {
    public static class json{
        public static String toStr(Object o, String defaultValue) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
