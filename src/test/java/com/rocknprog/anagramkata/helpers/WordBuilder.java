package com.rocknprog.anagramkata.helpers;

import static com.rocknprog.anagramkata.helpers.WordMother.createWord;

import com.rocknprog.anagramkata.domain.Word;

public class WordBuilder {
  private final String word = createWord();

  private WordBuilder() {}

  public static WordBuilder aWord() {
    return new WordBuilder();
  }

  public Word build() {
    return new Word(word);
  }
}
