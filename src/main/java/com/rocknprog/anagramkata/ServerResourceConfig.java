package com.rocknprog.anagramkata;

import com.rocknprog.anagramkata.api.AnagramResource;
import com.rocknprog.anagramkata.api.CORSResponseFilter;
import com.rocknprog.anagramkata.api.CatchAllExceptionMapper;
import com.rocknprog.anagramkata.filesystem.StringListFileReader;
import com.rocknprog.anagramkata.filesystem.WordListFileHelper;
import com.rocknprog.anagramkata.services.AnagramService;
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
                // TODO : Setup actual injection for resources
                HashSet<Object> resources = new HashSet<>();
                resources.add(
                    new AnagramResource(
                        new AnagramService(new WordListFileHelper(new StringListFileReader()))));
                return resources;
              }

              @Override
              public Set<Class<?>> getClasses() {
                // TODO : Setup actual injection for exception mappers
                HashSet<Class<?>> exceptionMappers = new HashSet<>();
                exceptionMappers.add(CatchAllExceptionMapper.class);
                return exceptionMappers;
              }
            });

    resourceConfig.register(CORSResponseFilter.class);

    return resourceConfig;
  }
}
