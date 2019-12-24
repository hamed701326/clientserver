package clientservernoncomplete.Client;

import java.io.*;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    static Socket client;
    static  DataInputStream clientIn=null;
    static DataOutputStream clientOut = null;
    static {
        try {
            client = new Socket("localhost",8888);
            clientIn=new DataInputStream(client.getInputStream());
            clientOut = new DataOutputStream(Client.client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(30);

        MessageOutClient messageOutClient=new MessageOutClient();
        Thread threadOut=new Thread(messageOutClient);
        Thread threadIn=new Thread(new MessageInClient());
//                    if(threadIn.getState().equals(Thread.State.TERMINATED)
//                    || threadIn.getState().equals(Thread.State.NEW)) {
//                        threadIn.start();
            executor.execute(threadIn);
            executor.execute(threadOut);



    }
}
