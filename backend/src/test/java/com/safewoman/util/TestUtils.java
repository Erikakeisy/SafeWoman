package com.safewoman.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {

    public static String readResourceFile(String path) throws IOException {
        File file = new ClassPathResource(path).getFile();
        return new String(Files.readAllBytes(Paths.get(file.getPath())), Charset.forName("UTF-8"));
    }

    public static <T> T getObjectFromJsonFile(String path, Class<T> type) throws IOException {
        File file = new ClassPathResource(path).getFile();
        String value = new String(Files.readAllBytes(Paths.get(file.getPath())), Charset.forName("UTF-8"));
        return getObjectMapper().readValue(value, type);
    }


    private static ObjectMapper getObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
