package com.rocknprog.anagramkata.helpers;

import static com.rocknprog.anagramkata.helpers.WordMother.createWord;

import com.rocknprog.anagramkata.services.dto.WordDto;

public class WordDtoBuilder {
  private String word = createWord();

  private WordDtoBuilder() {}

  public static WordDtoBuilder aWordDto() {
    return new WordDtoBuilder();
  }

  public WordDtoBuilder withWord(String word) {
    this.word = word;
    return this;
  }

  public WordDto build() {
    WordDto wordDto = new WordDto();
    wordDto.word = word;
    return wordDto;
  }
}
