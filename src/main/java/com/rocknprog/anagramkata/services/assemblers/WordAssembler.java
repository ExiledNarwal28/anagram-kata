package com.rocknprog.anagramkata.services.assemblers;

import com.rocknprog.anagramkata.domain.Word;
import com.rocknprog.anagramkata.services.dto.WordDto;
import java.util.List;
import java.util.stream.Collectors;

public class WordAssembler {

  public Word assemble(WordDto wordDto) {
    return assemble(wordDto.word);
  }

  public List<Word> assemble(List<String> words) {
    return words.stream().map(this::assemble).collect(Collectors.toList());
  }

  private Word assemble(String word) {
    return new Word(word);
  }
}
