package com.rocknprog.anagramkata.anagrams.helpers;

import com.github.javafaker.Faker;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordMother {
  public static String createWord() {
    return Faker.instance().lorem().word();
  }

  public static List<String> createWords() {
    int numberOfWords = Faker.instance().number().numberBetween(5, 20);

    return IntStream.range(0, numberOfWords)
        .mapToObj(n -> createWord())
        .collect(Collectors.toList());
  }
}
