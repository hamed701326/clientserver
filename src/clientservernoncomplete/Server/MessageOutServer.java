package clientservernoncomplete.Server;

import clientservernoncomplete.Server.Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

 class MessageOutServer implements Runnable {
     private String messageOut="";
    @Override
    public void run() {
        try {
            while (true) {

                BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Server:");
                messageOut = systemIn.readLine();

                //sending
                if(messageOut!=null)
                Server.serverOut.println(messageOut);
            }
        }catch (IOException e){
            System.out.println("IOException occurred at Sending Message in Server");
        }
    }

    public String getMessageOut() {
        return messageOut;
    }
}
