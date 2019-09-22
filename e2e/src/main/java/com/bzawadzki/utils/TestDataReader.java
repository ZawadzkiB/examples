package com.bzawadzki.utils;

import com.bzawadzki.annotations.TestData;
import com.bzawadzki.exceptions.TestDataException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDataReader {

  private static TestDataReader INSTANCE;
  private static ObjectMapper objectMapper;

  private TestDataReader(){}

  public static TestDataReader getInstance() {
    if(INSTANCE == null){
      INSTANCE = new TestDataReader();
      objectMapper =  new ObjectMapper();
      objectMapper.registerModule(new JavaTimeModule());
    }

    return INSTANCE;
  }

  public <T> T readData(Class<T> clazz){
    try {
      return objectMapper.readValue(Files.readAllBytes(Paths.get(getDataPath(clazz))), clazz);
    } catch (IOException e) {
      throw new TestDataException(e.getMessage());
    }
  }

  private String getDataPath(Class clazz){
    Annotation annotation = clazz.getAnnotation(TestData.class);
    if(annotation != null){
      return ((TestData)annotation).path();
    }else{
      throw new TestDataException("Test data must be annotated with @TestData annotation");
    }
  }
}
