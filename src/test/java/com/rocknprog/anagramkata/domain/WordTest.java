package com.rocknprog.anagramkata.domain;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class WordTest {

  private final String wordValue = "value";
  private final Word word = new Word(wordValue);

  @Test
  public void givenAnagramWord_whenCheckingIfAnagram_thenReturnTrue() {
    Word anagram = new Word("avlue");

    boolean isAnagram = word.isAnagram(anagram);

    assertThat(isAnagram).isTrue();
  }

  @Test
  public void givenNonAnagramWord_whenCheckingIfAnagram_thenReturnFalse() {
    Word nonAnagram = new Word("volue");

    boolean isAnagram = word.isAnagram(nonAnagram);

    assertThat(isAnagram).isFalse();
  }

  @Test
  public void givenDifferenceLengthWord_whenCheckingIfAnagram_thenReturnFalse() {
    Word differentLengthWord = new Word("valuev");

    boolean isAnagram = word.isAnagram(differentLengthWord);

    assertThat(isAnagram).isFalse();
  }

  @Test
  public void givenSameWord_whenCheckingIfAnagram_thenReturnFalse() {
    Word sameWord = new Word(wordValue);

    boolean isAnagram = word.isAnagram(sameWord);

    assertThat(isAnagram).isFalse();
  }

  @Test
  public void givenSameCapitalizedWord_whenCheckingIfAnagram_thenReturnFalse() {
    Word sameCapitalizedWord = new Word(wordValue.toUpperCase());

    boolean isAnagram = word.isAnagram(sameCapitalizedWord);

    assertThat(isAnagram).isFalse();
  }

  @Test
  public void whenConvertingToString_thenReturnWord() {
    String stringValue = word.toString();

    assertThat(stringValue).isEqualTo(wordValue);
  }
}
