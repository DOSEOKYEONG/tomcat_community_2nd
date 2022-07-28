package com.ll.exam.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.Dto.ArticleDto;

import java.util.List;
import java.util.Map;

public class Ut {

    public static class json{
        private static final ObjectMapper objectMapper;

        static {
            objectMapper = new ObjectMapper();
        }
        public static String toStr(Object o, String defaultValue) {
            try {
                return objectMapper.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

//        public static Object toObj(String jsonStr, Class cls, Object o) {
//            try {
//                return objectMapper.readValue(jsonStr, cls);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException(e);
//            }
//        }

        public static <T> T toObj(String jsonStr, Class<T> T, T defaultValue) {
            try {
                return objectMapper.readValue(jsonStr, T);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <T> List<T> toObj(String jsonStr, TypeReference<List<T>> typeReference, List<T> defaultValue) {
            try {
                return objectMapper.readValue(jsonStr, typeReference);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static <K, V> Map<K, V> MaptoObj(String jsonStr, TypeReference<Map<K, V>> typeReference, Map<K, V> defaultValue) {
            try {
                return objectMapper.readValue(jsonStr, typeReference);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static String listToJson(List objList, String defaultValue) {
            try {
                return objectMapper.writeValueAsString(objList);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }

        public static String MapToJson(Map objMap, String defaultValue) {
            try {
                return objectMapper.writeValueAsString(objMap);
            } catch (JsonProcessingException e) {
                return defaultValue;
            }
        }
    }
}
