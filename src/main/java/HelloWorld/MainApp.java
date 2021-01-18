package HelloWorld;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.server.ServerEndpointConfig;

@Singleton
public class MainApp {
  @PostConstruct
  public static void init(String[] args) {
    ServerEndpointConfig.Builder.create(HelloWithoutAnnotations.class, "/hello").build();
  }
}
