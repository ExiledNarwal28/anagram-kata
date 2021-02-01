package com.rocknprog.anagramkata.api;

import static com.google.common.truth.Truth.assertThat;
import static com.rocknprog.anagramkata.helpers.AnagramListDtoBuilder.anAnagramListDto;
import static com.rocknprog.anagramkata.helpers.WordDtoBuilder.aWordDto;
import static org.mockito.Mockito.when;

import com.rocknprog.anagramkata.services.AnagramService;
import com.rocknprog.anagramkata.services.dto.AnagramListDto;
import com.rocknprog.anagramkata.services.dto.WordDto;
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
  private final AnagramListDto anagramListDto = anAnagramListDto().build();

  @Before
  public void setup() {
    anagramResource = new AnagramResource(anagramService);

    when(anagramService.findAnagrams(wordDto)).thenReturn(anagramListDto);
  }

  @Test
  public void whenFindAnagrams_thenRespondAnagramsDto() {
    Response response = anagramResource.findAnagrams(wordDto);
    AnagramListDto respondedAnagramListDto = (AnagramListDto) response.getEntity();

    assertThat(respondedAnagramListDto).isSameInstanceAs(anagramListDto);
  }

  @Test
  public void whenFindAnagrams_thenRespondOkStatus() {
    Response response = anagramResource.findAnagrams(wordDto);

    assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
  }
}
