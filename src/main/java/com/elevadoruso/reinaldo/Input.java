package com.elevadoruso.reinaldo;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Input {

    ObjectMapper objectMapper = new ObjectMapper();
    InputStream inputStream = new FileInputStream("src/main/resources/input.json");
    TypeReference<List<Elevador>> typeReference = new TypeReference<>() {
    };
    List<Elevador> elevadores = objectMapper.readValue(inputStream, typeReference);

    public Input() throws IOException {
    }
}