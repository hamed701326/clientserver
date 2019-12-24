package simpleclientserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {
        try(
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket s = serverSocket.accept();
            BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(s.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        ){
            String msgOut="",msgIn;
            do {
                if((msgIn = reader.readLine())!=null)
                System.out.println("Client: " + msgIn);

                System.out.print("Server:");
                msgOut = systemIn.readLine();

                //sending
                writer.println(msgOut);

           }while (!msgOut.equals("exit"));
            s.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
