package com.rocknprog.anagramkata.helpers;

import static com.rocknprog.anagramkata.helpers.WordMother.createWord;

import com.rocknprog.anagramkata.services.dto.WordDto;

public class WordDtoBuilder {
  private final String word = createWord();

  private WordDtoBuilder() {}

  public static WordDtoBuilder aWordDto() {
    return new WordDtoBuilder();
  }

  public WordDto build() {
    WordDto wordDto = new WordDto();
    wordDto.word = word;
    return wordDto;
  }
}
