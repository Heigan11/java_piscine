package edu.school21.sockets.client;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Component("client")
public class Client {

    private Socket client;
    private BufferedReader console;
    private BufferedReader in;
    private BufferedWriter out;

    public void doLogic(int port) throws IOException {

        client = new Socket("localhost", port);
        console = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        String serverResponse = in.readLine();
        System.out.println(serverResponse);


        do {

            if(!serverResponse.equals("Successful!") && !serverResponse.equals("Try again.")) {
                System.out.print("> ");
                String word = console.readLine();

                out.write(word + "\n");
                out.flush();
            }

            serverResponse = in.readLine();
            System.out.println(serverResponse);

        } while (!serverResponse.equals("Exit"));

        client.close();
        in.close();
        out.close();
    }
}
