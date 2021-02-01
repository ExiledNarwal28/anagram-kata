package com.rocknprog.anagramkata.anagrams.api;

import static com.google.common.truth.Truth.assertThat;
import static com.rocknprog.anagramkata.anagrams.helpers.AnagramsDtoBuilder.anAnagramsDto;
import static com.rocknprog.anagramkata.anagrams.helpers.WordDtoBuilder.aWordDto;
import static org.mockito.Mockito.when;

import com.rocknprog.anagramkata.anagrams.services.AnagramService;
import com.rocknprog.anagramkata.anagrams.services.dto.AnagramsDto;
import com.rocknprog.anagramkata.anagrams.services.dto.WordDto;
import javax.ws.rs.core.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AnagramResourceTest {

  @Mock private AnagramService anagramService;

  private AnagramResource anagramResource;

  private final WordDto wordDto = aWordDto().build();
  private final AnagramsDto anagramsDto = anAnagramsDto().build();

  @Before
  public void setup() {
    anagramResource = new AnagramResource(anagramService);

    when(anagramService.findAnagrams(wordDto)).thenReturn(anagramsDto);
  }

  @Test
  public void whenFindAnagrams_thenRespondAnagramsDto() {
    Response response = anagramResource.findAnagrams(wordDto);
    AnagramsDto respondedAnagramsDto = (AnagramsDto) response.getEntity();

    assertThat(respondedAnagramsDto).isSameInstanceAs(anagramsDto);
  }

  @Test
  public void whenFindAnagrams_thenRespondOkStatus() {
    Response response = anagramResource.findAnagrams(wordDto);

    assertThat(response.getStatus()).isEqualTo(Response.Status.CREATED.getStatusCode());
  }
}
