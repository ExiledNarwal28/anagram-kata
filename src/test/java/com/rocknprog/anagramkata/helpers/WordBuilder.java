package com.rocknprog.anagramkata.helpers;

import static com.rocknprog.anagramkata.helpers.WordMother.createWord;

import com.rocknprog.anagramkata.domain.Word;

public class WordBuilder {
  private String word = createWord();

  private WordBuilder() {}

  public static WordBuilder aWord() {
    return new WordBuilder();
  }

  public WordBuilder withWord(String word) {
    this.word = word;
    return this;
  }

  public Word build() {
    return new Word(word);
  }
}
