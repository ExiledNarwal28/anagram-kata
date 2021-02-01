package com.rocknprog.anagramkata.anagrams.helpers;

import static com.rocknprog.anagramkata.anagrams.helpers.WordMother.createWords;

import com.rocknprog.anagramkata.anagrams.services.dto.AnagramListDto;
import java.util.List;

public class AnagramListDtoBuilder {
  private final List<String> anagrams = createWords();

  private AnagramListDtoBuilder() {}

  public static AnagramListDtoBuilder anAnagramListDto() {
    return new AnagramListDtoBuilder();
  }

  public AnagramListDto build() {
    AnagramListDto wordDto = new AnagramListDto();
    wordDto.anagrams = anagrams;
    return wordDto;
  }
}
