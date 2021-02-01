package com.rocknprog.anagramkata.services.assemblers;

import com.rocknprog.anagramkata.domain.Word;
import com.rocknprog.anagramkata.services.dto.AnagramListDto;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramAssembler {

  public AnagramListDto assemble(List<Word> anagramList) {
    AnagramListDto anagramListDto = new AnagramListDto();
    anagramListDto.anagrams = anagramList.stream().map(Word::toString).collect(Collectors.toList());
    return anagramListDto;
  }
}
