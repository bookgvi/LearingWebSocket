package HelloWorld;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/hey")
public class HelloWithAnnotations {
  @OnMessage
  public void sendMessage(Session session) {
    try {
      session.getBasicRemote().sendText("QQQ");
    } catch (IOException ignored) {
    }
  }
}
