package edu.school21.sockets.server;

import edu.school21.sockets.services.MessageService;
import edu.school21.sockets.services.UsersService;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.LinkedList;

@Component("server")
public class Server {

    private final UsersService usersService;
    private final MessageService messageService;

    public static LinkedList<ClientListener> serverList = new LinkedList<>();

    public Server(UsersService usersService, MessageService messageService) {
        this.usersService = usersService;
        this.messageService = messageService;
    }

    public void doLogic(int port) throws IOException, SQLException {
        long id = 0;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server start with port=" + port);
            while (true) {
                System.out.println(serverList.size() + " clients connected to the server");
                Socket socket = server.accept();
                try {
                    serverList.add(new ClientListener(socket, ++id, usersService, messageService));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
