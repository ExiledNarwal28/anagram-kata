package com.rocknprog.anagramkata.filesystem;

import com.rocknprog.anagramkata.domain.WordListHelper;
import java.util.ArrayList;
import java.util.List;

public class WordListFileHelper implements WordListHelper {

  private static final String WORD_LIST_FILE_NAME = "wordlist.txt";

  private final StringListFileReader fileReader;

  public WordListFileHelper(StringListFileReader fileReader) {
    this.fileReader = fileReader;
  }

  @Override
  public List<String> getWordList() {
    // TODO : Implement WordListFileHelper.getWordList
    return new ArrayList<>();
  }
}
