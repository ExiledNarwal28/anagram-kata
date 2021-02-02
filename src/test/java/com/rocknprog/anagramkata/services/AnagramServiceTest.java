package com.rocknprog.anagramkata.services;

import static com.google.common.truth.Truth.assertThat;
import static com.rocknprog.anagramkata.helpers.AnagramListDtoBuilder.anAnagramListDto;
import static com.rocknprog.anagramkata.helpers.WordBuilder.aWord;
import static com.rocknprog.anagramkata.helpers.WordDtoBuilder.aWordDto;
import static com.rocknprog.anagramkata.helpers.WordMother.createWord;
import static org.mockito.Mockito.when;

import com.rocknprog.anagramkata.domain.Word;
import com.rocknprog.anagramkata.domain.WordListHelper;
import com.rocknprog.anagramkata.services.assemblers.AnagramAssembler;
import com.rocknprog.anagramkata.services.assemblers.WordAssembler;
import com.rocknprog.anagramkata.services.dto.AnagramListDto;
import com.rocknprog.anagramkata.services.dto.WordDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnagramServiceTest {
  @Mock private WordListHelper wordListHelper;
  @Mock private WordAssembler wordAssembler;
  @Mock private AnagramAssembler anagramAssembler;

  private AnagramService anagramService;

  private final AnagramListDto anagramListDto = anAnagramListDto().build();
  private final List<String> stringList = Collections.singletonList(createWord());
  private WordDto wordDto;

  @Before
  public void setup() {
    anagramService = new AnagramService(wordListHelper, wordAssembler, anagramAssembler);

    String wordValue = "word";
    wordDto = aWordDto().withWord(wordValue).build();
    Word word = aWord().withWord(wordValue).build();
    Word anagram = aWord().withWord("wrod").build();
    Word nonAnagram = aWord().withWord("wordd").build();
    List<Word> wordList = Arrays.asList(word, anagram, nonAnagram);

    when(wordListHelper.getWordList()).thenReturn(stringList);
    when(wordAssembler.assemble(stringList)).thenReturn(wordList);
    when(wordAssembler.assemble(wordDto)).thenReturn(word);
    when(anagramAssembler.assemble(Collections.singletonList(anagram))).thenReturn(anagramListDto);
  }

  @Test
  public void whenFindingAnagrams_thenReturnAnagrams() {
    AnagramListDto foundAnagramListDto = anagramService.findAnagrams(wordDto);

    assertThat(foundAnagramListDto).isSameInstanceAs(anagramListDto);
  }
}
