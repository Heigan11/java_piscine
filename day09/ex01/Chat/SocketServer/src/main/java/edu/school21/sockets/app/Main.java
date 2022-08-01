package edu.school21.sockets.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;
import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.server.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        ParametersParser parametersParser = new ParametersParser();
        try {
            JCommander.
                    newBuilder().
                    addObject(parametersParser).
                    build().
                    parse(args);
        } catch (ParameterException ex){
            throw new ParameterException("not valid parameters");
        }

        parametersParser.validateParameters();

        ApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);

        Server server = context.getBean("server", Server.class);
        try {
            server.doLogic(parametersParser.getPort());
        } catch (SQLException | IOException e) {
            System.out.println("session end");
            System.exit(1);
        }

        UsersRepository usersRepository = context.getBean("usersRepository", UsersRepository.class);
        System.out.println(usersRepository.findAll());

    }
}
