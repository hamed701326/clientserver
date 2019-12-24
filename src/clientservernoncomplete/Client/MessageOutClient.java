package clientservernoncomplete.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageOutClient implements Runnable {
    private String messageOut="";
    @Override
    public void run()  {
       try {

           BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
           System.out.print("client: ");
           messageOut = systemIn.readLine();
           Client.clientOut.writeUTF(messageOut);
           Client.clientOut.flush();
       }catch (IOException e){
           System.out.println("IOException occurred at sending message in Client ");
       }

    }

    public String getMessageOut() {
        return messageOut;
    }
}
