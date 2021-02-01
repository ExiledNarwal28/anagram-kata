package com.rocknprog.anagramkata.domain;

import java.util.Arrays;

public class Word {
  private final String word;

  public Word(String word) {
    this.word = word;
  }

  public boolean isAnagram(Word potentialAnagram) {
    String otherWord = potentialAnagram.toString();

    if (word.equals(otherWord)) {
      return false;
    }

    if (word.length() != otherWord.length()) {
      return false;
    }

    String myWord = word.toLowerCase();
    otherWord = otherWord.toLowerCase();
    char[] c1 = myWord.toCharArray();
    char[] c2 = otherWord.toCharArray();
    Arrays.sort(c1);
    Arrays.sort(c2);
    String sc1 = new String(c1);
    String sc2 = new String(c2);

    return sc1.equals(sc2);
  }

  @Override
  public String toString() {
    return word;
  }
}
