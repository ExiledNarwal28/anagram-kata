package com.rocknprog.anagramkata;

import com.rocknprog.anagramkata.anagrams.api.AnagramResource;
import com.rocknprog.anagramkata.anagrams.services.AnagramService;
import com.rocknprog.anagramkata.http.api.CORSResponseFilter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;

public class ServerResourceConfig {
  public static ResourceConfig getApplicationResourceConfig() {
    ResourceConfig resourceConfig =
        ResourceConfig.forApplication(
            new Application() {
              @Override
              public Set<Object> getSingletons() {
                HashSet<Object> resources = new HashSet<>();
                // TODO : Setup actual injection for resources
                resources.add(new AnagramResource(new AnagramService()));
                return resources;
              }

              @Override
              public Set<Class<?>> getClasses() {
                // TODO : Setup actual injection for exception mappers
                return Collections.emptySet();
              }
            });

    resourceConfig.register(CORSResponseFilter.class);

    return resourceConfig;
  }
}
