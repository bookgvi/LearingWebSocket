package HelloWorld;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Random;
import java.util.logging.Logger;

@Singleton
@Startup
public class StartWebSocket {
  @Resource
  TimerService timerService;

  @PostConstruct
  void init() {
    Logger.getLogger("WEBSocket").info("Initialize EJB");
    timerService.createIntervalTimer(1000, 5000, new TimerConfig());
//    ServerEndpointConfig.Builder.create(HelloWithoutAnnotations.class, "/hello").build();
  }

  @Timeout
  public void sendMessageToClient(Timer timer) throws Exception {
    HelloWithAnnotations.sendMessage(String.valueOf(new Random().nextInt(100)));
  }
}
