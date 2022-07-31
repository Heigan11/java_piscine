package edu.school21.sockets.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import edu.school21.sockets.client.Client;
import edu.school21.sockets.config.SocketsApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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

        Client client = context.getBean("client", Client.class);
        client.doLogic(parametersParser.getPort());
    }
}
