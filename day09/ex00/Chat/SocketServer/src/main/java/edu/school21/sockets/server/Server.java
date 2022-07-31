package edu.school21.sockets.server;

import edu.school21.sockets.services.UsersService;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

@Component("server")
public class Server {

    private final UsersService usersService;

    public Server(UsersService usersService) {
        this.usersService = usersService;
    }

    public void doLogic(int port) throws IOException, SQLException {
        ServerSocket server = new ServerSocket(port);
        Socket client = server.accept();
        String command;
        String username;
        String password;

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        out.write("Hello from Server!\n");
        out.flush();

        while (true) {
            while (true) {
                command = in.readLine();
                if (command != null && command.equals("signUp")){
                    break;
                }
                out.write("Unknown command\n");
                out.flush();
            }

            out.write("Enter username:\n");
            out.flush();

            username = in.readLine();

            out.write("Enter password:\n");
            out.flush();

            password = in.readLine();

            if (usersService.signUp(username, password)) {
                out.write("Successful!");
                out.flush();
                break;
            }

            out.write("Try again.\n");
            out.flush();
        }

        client.close();
        in.close();
        out.close();
        server.close();
    }
}
