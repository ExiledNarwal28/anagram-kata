package com.rocknprog.anagramkata.services.assemblers;

import static com.google.common.truth.Truth.assertThat;
import static com.rocknprog.anagramkata.helpers.WordBuilder.aWord;
import static com.rocknprog.anagramkata.helpers.WordDtoBuilder.aWordDto;

import com.rocknprog.anagramkata.domain.Word;
import com.rocknprog.anagramkata.services.dto.WordDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class WordAssemblerTest {

  private WordAssembler wordAssembler;

  private final Word word = aWord().build();
  private final Word otherWord = aWord().build();

  @Before
  public void setup() {
    wordAssembler = new WordAssembler();
  }

  @Test
  public void givenWordDto_whenAssembling_thenReturnWord() {
    WordDto wordDto = aWordDto().withWord(word.toString()).build();

    Word assembledWord = wordAssembler.assemble(wordDto);

    assertThat(assembledWord).isEqualTo(word);
  }

  @Test
  public void givenNoWord_whenAssembling_thenReturnEmptyList() {
    List<String> words = Collections.emptyList();

    List<Word> assembledWords = wordAssembler.assemble(words);

    assertThat(assembledWords).isEmpty();
  }

  @Test
  public void givenASingleWord_whenAssembling_thenReturnWordList() {
    List<String> words = Collections.singletonList(word.toString());

    List<Word> assembledWords = wordAssembler.assemble(words);

    assertThat(assembledWords).hasSize(1);
    assertThat(assembledWords.get(0)).isEqualTo(word);
  }

  @Test
  public void givenMultipleWords_whenAssembling_thenReturnWordList() {
    List<String> words = Arrays.asList(word.toString(), otherWord.toString());

    List<Word> assembledWords = wordAssembler.assemble(words);

    assertThat(assembledWords).hasSize(2);
    assertThat(assembledWords.get(0)).isEqualTo(word);
    assertThat(assembledWords.get(1)).isEqualTo(otherWord);
  }
}
