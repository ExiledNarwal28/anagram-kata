package com.rocknprog.anagramkata.anagrams.filesystem;

import com.rocknprog.anagramkata.anagrams.domain.WordListHelper;
import com.rocknprog.anagramkata.files.filesystem.StringListFileReader;
import java.util.ArrayList;
import java.util.List;

public class WordListFileHelper implements WordListHelper {

  private static final String EMAIL_PROPERTIES_FILE_PATH = "data/wordlist.txt";

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
