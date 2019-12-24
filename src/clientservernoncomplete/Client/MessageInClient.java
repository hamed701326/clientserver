package clientservernoncomplete.Client;

import java.io.DataInputStream;
import java.io.IOException;

public class MessageInClient implements Runnable {
    private String messageIn;
    @Override
    public void run() {
        try {
            //getting message from server
            messageIn=Client.clientIn.readUTF();
            System.out.println("server:" + messageIn);

        }catch (IOException e){
            System.out.println("IOException occurred at receiving message in Client");
        }

    }
}
