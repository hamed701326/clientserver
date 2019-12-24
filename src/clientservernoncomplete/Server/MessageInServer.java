package clientservernoncomplete.Server;

import java.io.DataInputStream;
import java.io.IOException;

class MessageInServer implements Runnable {
    private String messageIn;
    @Override
    public void run() {

        try {
            while (true) {
                messageIn = Server.serverIn.readLine();
                if (messageIn != null) {
                    System.out.println("Client: " + messageIn);
                }
            }
        }
        catch (IOException e){
            System.out.println("IOException occurred at Receiving Message in Server");
        }

    }
}
