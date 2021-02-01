package com.rocknprog.anagramkata.filesystem;

import static com.google.common.truth.Truth.assertThat;
import static com.rocknprog.anagramkata.helpers.WordMother.createWordList;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordListFileHelperTest {

  @Mock private StringListFileReader stringListFileReader;

  private WordListFileHelper wordListFileHelper;

  private final List<String> wordList = createWordList();

  @Before
  public void setup() {
    wordListFileHelper = new WordListFileHelper(stringListFileReader);

    when(stringListFileReader.readFile("wordlist.txt")).thenReturn(wordList);
  }

  @Test
  public void whenGettingWordList_thenReturnWordListFromFileReader() {
    List<String> receivedWordList = wordListFileHelper.getWordList();

    assertThat(receivedWordList).isSameInstanceAs(wordList);
  }
}
