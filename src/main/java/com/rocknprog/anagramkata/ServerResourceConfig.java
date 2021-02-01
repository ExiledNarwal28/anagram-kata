package com.rocknprog.anagramkata;

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
                /*
                resources.add(APPLICATION_INJECTOR.createUserResource());
                resources.add(APPLICATION_INJECTOR.createOffenseResource());
                resources.add(APPLICATION_INJECTOR.createGateResource());
                resources.add(APPLICATION_INJECTOR.createCarbonCreditResource());
                resources.add(APPLICATION_INJECTOR.createParkingAreaResource());
                resources.add(APPLICATION_INJECTOR.createInitiativeResource());
                resources.add(APPLICATION_INJECTOR.createReportProfitResource());
                resources.add(APPLICATION_INJECTOR.createReportParkingAreaResource());
                */
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
