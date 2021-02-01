package com.rocknprog.anagramkata.filesystem;

import static com.google.common.truth.Truth.assertThat;

import com.rocknprog.anagramkata.domain.exceptions.InvalidFileException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class StringListFileReaderTest {

  private StringListFileReader stringListFileReader;

  private static final String VALID_PROPERTIES_PATH = "stringlist.txt";
  private static final String INVALID_PROPERTIES_PATH = "invalid.txt";

  @Before
  public void setUp() {
    stringListFileReader = new StringListFileReader();
  }

  @Test
  public void whenReadingFile_thenConvertItToStringList() {
    String firstExpectedString = "first";
    String secondExpectedString = "second";

    List<String> stringList = stringListFileReader.readFile(VALID_PROPERTIES_PATH);

    assertThat(stringList).isNotEmpty();
    assertThat(stringList.get(0)).isEqualTo(firstExpectedString);
    assertThat(stringList.get(1)).isEqualTo(secondExpectedString);
  }

  @Test(expected = InvalidFileException.class)
  public void givenInvalidFilePath_whenReadingFile_thenThrowInvalidFileException() {
    stringListFileReader.readFile(INVALID_PROPERTIES_PATH);
  }
}
