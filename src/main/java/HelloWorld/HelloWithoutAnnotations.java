package HelloWorld;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import java.io.IOException;

public class HelloWithoutAnnotations extends Endpoint {
  @Override
  public void onOpen(final Session session, EndpointConfig endpointConfig) {
    session.addMessageHandler(new MessageHandler.Whole<String>() {
      public void onMessage(String s) {
        try {
          session.getBasicRemote().sendText(s + " world!");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
