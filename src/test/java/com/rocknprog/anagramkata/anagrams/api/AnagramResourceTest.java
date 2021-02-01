package com.rocknprog.anagramkata.anagrams.api;

import static com.google.common.truth.Truth.assertThat;

import javax.ws.rs.core.Response;
import org.junit.Before;
import org.junit.Test;

public class AnagramResourceTest {

  private AnagramResource anagramResource;

  @Before
  public void setup() {
    anagramResource = new AnagramResource();
  }

  @Test
  public void whenFindAnagrams_thenRespondOkStatus() {
    Response response = anagramResource.findAnagrams();

    assertThat(response.getStatus()).isEqualTo(Response.Status.CREATED.getStatusCode());
  }
}
