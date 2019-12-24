package clientservernoncomplete.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    static Socket s;
    static BufferedReader serverIn;
    static PrintWriter serverOut;
    static {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            s = serverSocket.accept();
            serverOut = new PrintWriter(Server.s.getOutputStream(),true);
            serverIn = new BufferedReader(new InputStreamReader(Server.s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(50);
        try{

            Thread threadIn=new Thread(new MessageInServer());
            MessageOutServer msgOut=new MessageOutServer();
            Thread threadOut=new Thread(msgOut);

//                if(threadIn.getState().equals(Thread.State.NEW))
//                    threadIn.start();
//                    msgOut.run();
            executor.execute(threadIn);
            executor.execute(threadOut);
            s.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
