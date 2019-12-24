package multiclientserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Handler extends Thread {
    private Socket client;
    private int clientCounter;
    public Handler(Socket client,int clientCounter) {
        this.clientCounter=clientCounter;
        this.client=client;
    }

    @Override
    public void run(){
        try (
            //Streams
            BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));        ){
            // -----------------------------------------------------------------
            System.out.printf("Client %d started.\n",clientCounter);
            String msgIn = "", msgOut = "";
            while (!msgIn.equals("exit")) {
                if((msgIn = reader.readLine())!=null)
                System.out.printf("Client %d: %s \n",clientCounter,msgIn);
                System.out.printf("Server to Client %d: ",clientCounter);
                msgOut=systemIn.readLine();
                writer.println(msgOut);
                writer.flush();
            }
            client.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.printf("Client %d exit.\n",clientCounter);
        }
    }
}
