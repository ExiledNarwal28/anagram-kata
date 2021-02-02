package com.rocknprog.anagramkata.services;

import com.rocknprog.anagramkata.domain.Word;
import com.rocknprog.anagramkata.domain.WordListHelper;
import com.rocknprog.anagramkata.services.assemblers.AnagramAssembler;
import com.rocknprog.anagramkata.services.assemblers.WordAssembler;
import com.rocknprog.anagramkata.services.dto.AnagramListDto;
import com.rocknprog.anagramkata.services.dto.WordDto;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramService {

  private final WordListHelper wordListHelper;
  private final WordAssembler wordAssembler;
  private final AnagramAssembler anagramAssembler;

  public AnagramService(WordListHelper wordListHelper) {
    this.wordListHelper = wordListHelper;
    wordAssembler = new WordAssembler();
    anagramAssembler = new AnagramAssembler();
  }

  public AnagramService(
      WordListHelper wordListHelper,
      WordAssembler wordAssembler,
      AnagramAssembler anagramAssembler) {
    this.wordListHelper = wordListHelper;
    this.wordAssembler = wordAssembler;
    this.anagramAssembler = anagramAssembler;
  }

  public AnagramListDto findAnagrams(WordDto wordDto) {
    List<String> stringList = wordListHelper.getWordList();

    List<Word> wordList = wordAssembler.assemble(stringList);
    Word givenWord = wordAssembler.assemble(wordDto);

    List<Word> anagramList =
        wordList.stream().filter(word -> word.isAnagram(givenWord)).collect(Collectors.toList());

    return anagramAssembler.assemble(anagramList);
  }
}
