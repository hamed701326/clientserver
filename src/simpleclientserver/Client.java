package simpleclientserver;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {

        try(
            Socket client=new Socket("localhost",8888);

            BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        ){
            String msgOut="",msgIn;
            do {
                System.out.print("client: ");
                msgOut = systemIn.readLine();
                writer.println(msgOut);

                //getting message from server
                if((msgIn= reader.readLine())!=null) System.out.println("server:" + msgIn);


            }while (!msgOut.equals("exit"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
