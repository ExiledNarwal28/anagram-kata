package com.rocknprog.anagramkata.helpers;

import static com.rocknprog.anagramkata.helpers.WordMother.createWordList;

import com.rocknprog.anagramkata.services.dto.AnagramListDto;
import java.util.List;

public class AnagramListDtoBuilder {
  private final List<String> anagrams = createWordList();

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
