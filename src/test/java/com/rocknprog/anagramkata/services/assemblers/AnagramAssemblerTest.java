package com.rocknprog.anagramkata.services.assemblers;

import static com.google.common.truth.Truth.assertThat;
import static com.rocknprog.anagramkata.helpers.WordBuilder.aWord;

import com.rocknprog.anagramkata.domain.Word;
import com.rocknprog.anagramkata.services.dto.AnagramListDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class AnagramAssemblerTest {

  private AnagramAssembler anagramAssembler;

  private final Word anagram = aWord().build();
  private final Word otherAnagram = aWord().build();

  @Before
  public void setup() {
    anagramAssembler = new AnagramAssembler();
  }

  @Test
  public void givenNoAnagrams_whenAssembling_thenReturnEmptyList() {
    List<Word> anagrams = Collections.emptyList();

    AnagramListDto anagramListDto = anagramAssembler.assemble(anagrams);

    assertThat(anagramListDto.anagrams).isEmpty();
  }

  @Test
  public void givenASingleAnagrams_whenAssembling_thenReturnAnagramList() {
    List<Word> anagrams = Collections.singletonList(anagram);

    AnagramListDto anagramListDto = anagramAssembler.assemble(anagrams);

    assertThat(anagramListDto.anagrams).hasSize(1);
    assertThat(anagramListDto.anagrams.get(0)).isEqualTo(anagram.toString());
  }

  @Test
  public void givenMultipleAnagrams_whenAssembling_thenReturnAnagramList() {
    List<Word> anagrams = Arrays.asList(anagram, otherAnagram);

    AnagramListDto anagramListDto = anagramAssembler.assemble(anagrams);

    assertThat(anagramListDto.anagrams).hasSize(2);
    assertThat(anagramListDto.anagrams.get(0)).isEqualTo(anagram.toString());
    assertThat(anagramListDto.anagrams.get(1)).isEqualTo(otherAnagram.toString());
  }
}
