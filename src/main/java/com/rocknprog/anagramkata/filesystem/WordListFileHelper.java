package com.rocknprog.anagramkata.filesystem;

import com.rocknprog.anagramkata.domain.WordListHelper;
import java.util.List;

public class WordListFileHelper implements WordListHelper {

  private static final String WORD_LIST_FILE_NAME = "wordlist.txt";

  private final StringListFileReader fileReader;

  public WordListFileHelper(StringListFileReader fileReader) {
    this.fileReader = fileReader;
  }

  @Override
  public List<String> getWordList() {
    return fileReader.readFile(WORD_LIST_FILE_NAME);
  }
}
