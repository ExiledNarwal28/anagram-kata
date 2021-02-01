package com.rocknprog.anagramkata.services;

import com.rocknprog.anagramkata.domain.Word;
import com.rocknprog.anagramkata.domain.WordListHelper;
import com.rocknprog.anagramkata.services.dto.AnagramListDto;
import com.rocknprog.anagramkata.services.dto.WordDto;
import java.util.List;
import java.util.stream.Collectors;

public class AnagramService {

  private final WordListHelper wordListHelper;

  public AnagramService(WordListHelper wordListHelper) {
    this.wordListHelper = wordListHelper;
  }

  public AnagramListDto findAnagrams(WordDto wordDto) {
    List<String> stringList = wordListHelper.getWordList();

    List<Word> wordList = stringList.stream().map(Word::new).collect(Collectors.toList());
    Word givenWord = new Word(wordDto.word);

    List<Word> anagramList =
        wordList.stream().filter(word -> word.isAnagram(givenWord)).collect(Collectors.toList());

    AnagramListDto anagramListDto = new AnagramListDto();
    anagramListDto.anagrams = anagramList.stream().map(Word::toString).collect(Collectors.toList());

    return anagramListDto;
  }
}
