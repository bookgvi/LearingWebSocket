package HelloWorld;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

@ServerEndpoint("/hey")
public class HelloWithAnnotations {
  private static Queue<Session> sessionsQueue = new ConcurrentLinkedQueue<Session>();

  @OnOpen
  public void openConnection(Session session, EndpointConfig endpointConfig) {
    Logger.getLogger("WEBSocket").info("Open");
    HelloWithAnnotations.sessionsQueue.add(session);
  }

  @OnClose
  public void closeConnection(Session session) {
    HelloWithAnnotations.sessionsQueue.remove(session);
    Logger.getLogger("WEBSocket").info("Close");
  }

  @OnError
  public void errorConnection(Session session, Throwable throwable) {
    HelloWithAnnotations.sessionsQueue.remove(session);
    Logger.getLogger("WEBSocket").warning("ERROR " + throwable.getMessage());
  }

  @OnMessage
  public void getMessage(Session session, String msg) {
    Logger.getLogger("WEBSocket").info("Message " + msg);
  }

  static void sendMessage(String s) {
    try {
      for (Session session : sessionsQueue) {
        session.getBasicRemote().sendText(s);
      }
    } catch (IOException ioEx) {
      Logger.getLogger("WEBSocket").warning("ERROR while sending msg " + ioEx.getMessage());
    }
  }
}
