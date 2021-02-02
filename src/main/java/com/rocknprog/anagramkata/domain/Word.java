package com.rocknprog.anagramkata.domain;

import java.util.Arrays;

public class Word {
  private final String word;

  public Word(String word) {
    this.word = word;
  }

  public boolean isAnagram(Word potentialAnagram) {
    String otherWord = potentialAnagram.toString();

    if (word.length() != otherWord.length()) {
      return false;
    }

    String myWord = word.toLowerCase();
    otherWord = otherWord.toLowerCase();

    if (myWord.equals(otherWord)) {
      return false;
    }

    myWord = sortString(myWord);
    otherWord = sortString(otherWord);

    return myWord.equals(otherWord);
  }

  private String sortString(String string) {
    char[] charArray = string.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }

  @Override
  public String toString() {
    return word;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || getClass() != object.getClass()) return false;

    Word otherWord = (Word) object;

    return word.equals(otherWord.toString());
  }

  @Override
  public int hashCode() {
    return word.hashCode();
  }
}
