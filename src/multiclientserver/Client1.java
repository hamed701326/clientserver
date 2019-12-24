package multiclientserver;

import java.io.*;
import java.net.Socket;


public class Client1 {
    public static void main(String[] args) throws Exception {
        try (
            Socket socket = new Socket("localhost", 8888);
            BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            String msgIn = "", msgOut = "";

            while (!msgOut.equals("exit")) {

                System.out.print("client: ");
                msgOut = systemIn.readLine();
                writer.println(msgOut);
                if((msgIn = reader.readLine())!=null)
                System.out.println("server: "+msgIn);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}