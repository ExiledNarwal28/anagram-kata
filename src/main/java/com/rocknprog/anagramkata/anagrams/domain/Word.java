package com.rocknprog.anagramkata.anagrams.domain;

public class Word {
  private final String word;

  public Word(String word) {
    this.word = word;
  }

  public boolean isAnagram(Word otherWord) {
    // TODO : Implement Word.isAnagram
    return true;
  }

  // TODO : Implement Word.toString
  @Override
  public String toString() {
    return word;
  }
}
