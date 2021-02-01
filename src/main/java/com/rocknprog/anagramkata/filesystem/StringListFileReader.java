package com.rocknprog.anagramkata.filesystem;

import com.rocknprog.anagramkata.domain.exceptions.InvalidFileException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StringListFileReader {

  public List<String> readFile(String fileName) {
    return convertInputStream(getFileFromResourceAsStream(fileName));
  }

  private InputStream getFileFromResourceAsStream(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);

    if (inputStream == null) {
      throw new InvalidFileException();
    } else {
      return inputStream;
    }
  }

  private List<String> convertInputStream(InputStream is) {
    List<String> stringList = new ArrayList<>();

    try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader)) {

      String line;
      while ((line = reader.readLine()) != null) {
        stringList.add(line);
      }
    } catch (IOException e) {
      throw new InvalidFileException();
    }

    return stringList;
  }
}
