package com.rocknprog.anagramkata.anagrams.helpers;

import static com.rocknprog.anagramkata.anagrams.helpers.WordMother.createWords;

import com.rocknprog.anagramkata.anagrams.services.dto.AnagramsDto;
import java.util.List;

public class AnagramsDtoBuilder {
  private final List<String> anagrams = createWords();

  private AnagramsDtoBuilder() {}

  public static AnagramsDtoBuilder anAnagramsDto() {
    return new AnagramsDtoBuilder();
  }

  public AnagramsDto build() {
    AnagramsDto wordDto = new AnagramsDto();
    wordDto.anagrams = anagrams;
    return wordDto;
  }
}
