package com.rocknprog.anagramkata.anagrams.services;

import com.rocknprog.anagramkata.anagrams.domain.Word;
import com.rocknprog.anagramkata.anagrams.domain.WordListHelper;
import com.rocknprog.anagramkata.anagrams.services.dto.AnagramListDto;
import com.rocknprog.anagramkata.anagrams.services.dto.WordDto;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramService {

  private final WordListHelper wordListHelper;

  public AnagramService(WordListHelper wordListHelper) {
    this.wordListHelper = wordListHelper;
  }

  // TODO : Test AnagramService.findAnagrams
  public AnagramListDto findAnagrams(WordDto wordDto) {
    List<String> stringList = wordListHelper.getWordList();

    List<Word> wordList =
        stringList.stream()
            .map(Word::new)
            .collect(Collectors.toList()); // TODO : Implement WordAssembler

    Word givenWord = new Word(wordDto.word); // TODO : Implement WordAssembler

    List<Word> anagramList =
        wordList.stream().filter(word -> word.isAnagram(givenWord)).collect(Collectors.toList());

    // TODO : Implement AnagramAssembler
    AnagramListDto anagramListDto = new AnagramListDto();
    anagramListDto.anagrams = anagramList.stream().map(Word::toString).collect(Collectors.toList());

    return anagramListDto;
  }
}
