//package HelloWorld;
//
//import javax.websocket.Endpoint;
//import javax.websocket.server.ServerApplicationConfig;
//import javax.websocket.server.ServerEndpointConfig;
//import java.util.HashSet;
//import java.util.Set;
//
//public class MainApp implements ServerApplicationConfig {
//
//  public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
//    Set<ServerEndpointConfig> result = new HashSet<ServerEndpointConfig>();
//    for (Class epClass : set) {
//      if (epClass.equals(HelloWithoutAnnotations.class)) {
//        ServerEndpointConfig sec = ServerEndpointConfig.Builder.create(epClass, "/hello").build();
//        result.add(sec);
//      }
//    }
//    return result;
//  }
//
//  public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
//    return null;
//  }
//}
