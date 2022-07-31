package edu.school21.sockets.app;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class ParametersParser {
    @Parameter(names = "--port")
    private int port;

    public void validateParameters() {
        if (port < 1024 || port > 65535){
            throw new ParameterException("not valid parameters");
        }
    }

    public int getPort(){
        return port;
    }

}
