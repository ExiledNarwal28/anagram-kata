package com.rocknprog.anagramkata.api;

import static com.google.common.truth.Truth.assertThat;

import com.rocknprog.anagramkata.domain.exceptions.AnagramException;
import com.rocknprog.anagramkata.domain.exceptions.InvalidFileException;
import javax.ws.rs.core.Response;
import org.junit.Before;
import org.junit.Test;

public class AnagramExceptionMapperTest {
  private AnagramExceptionMapper anagramExceptionMapper;

  @Before
  public void setUp() {
    anagramExceptionMapper = new AnagramExceptionMapper();
  }

  @Test
  public void givenInvalidFileException_whenResponding_thenStatusIsInternalServerError() {
    AnagramException anagramException = new InvalidFileException();

    Response response = anagramExceptionMapper.toResponse(anagramException);

    assertThat(response.getStatus())
        .isEqualTo(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
  }
}
