package multiclientserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ExecutorService executor= Executors.newFixedThreadPool(50);
        ServerSocket server;
        try {

            server = new ServerSocket(8888);
            System.out.println(" Server started ...");
            int clientCounter = 0;
            while (true) {
                clientCounter++;
                Socket client = server.accept();
               executor.execute(new Handler(client, clientCounter));
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
