package com.rocknprog.anagramkata.api;

import com.rocknprog.anagramkata.domain.exceptions.AnagramException;
import com.rocknprog.anagramkata.services.dto.ErrorDto;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AnagramExceptionMapper implements ExceptionMapper<AnagramException> {

  @Override
  public Response toResponse(AnagramException exception) {
    Response.Status responseStatus = Response.Status.INTERNAL_SERVER_ERROR;

    ErrorDto errorDto = new ErrorDto();
    errorDto.error = exception.error;
    errorDto.description = exception.description;

    return Response.status(responseStatus)
        .entity(errorDto)
        .type(MediaType.APPLICATION_JSON)
        .build();
  }
}
