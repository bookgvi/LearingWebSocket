package HelloWorld;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;
import java.util.logging.Logger;

public class HelloWithoutAnnotations extends Endpoint {
  @Override
  public void onOpen(final Session session, EndpointConfig endpointConfig) {
    Logger.getLogger("Socket").info("Session opened");
    session.addMessageHandler(new MessageHandler.Whole<String>() {
      public void onMessage(String s) {
        try {
          session.getBasicRemote().sendText(s + " world!");
          Logger.getLogger("Socket message handler").info("Input msg = " + s);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void onError(Session session, Throwable thr) {
    Logger.getLogger("Socket error").warning(thr.getMessage());
  }
}
