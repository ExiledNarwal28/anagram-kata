package com.rocknprog.anagramkata.anagrams.api;

import com.rocknprog.anagramkata.anagrams.services.AnagramService;
import com.rocknprog.anagramkata.anagrams.services.dto.AnagramListDto;
import com.rocknprog.anagramkata.anagrams.services.dto.WordDto;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/anagrams")
public class AnagramResource {

  private final AnagramService anagramService;

  public AnagramResource(AnagramService anagramService) {
    this.anagramService = anagramService;
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAnagrams(WordDto wordDto) {
    AnagramListDto anagramListDto = anagramService.findAnagrams(wordDto);

    return Response.status(Response.Status.OK)
        .entity(anagramListDto)
        .type(MediaType.APPLICATION_JSON)
        .build();
  }
}
