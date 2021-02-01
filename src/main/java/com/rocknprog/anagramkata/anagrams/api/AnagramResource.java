package com.rocknprog.anagramkata.anagrams.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/anagrams")
public class AnagramResource {

  // TODO : Add service
  @POST
  // @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAnagrams() {
    return Response.status(Response.Status.CREATED)
        // .entity(anagramsDto)
        .type(MediaType.APPLICATION_JSON)
        .build();
  }
}
