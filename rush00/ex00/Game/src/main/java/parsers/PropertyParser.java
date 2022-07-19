package parsers;

import models.Game;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyParser {

    private Properties props;

    public void setProperties() {
        try {
            InputStream is = getClass().getResourceAsStream("/application-dev.properties");
            props = new Properties();
            props.load(is);
            assert is != null;
            is.close();
            Game.getInstance().setProperties(props);
        }
        catch(IOException ioe) {
            ioe.printStackTrace(System.out);
            System.exit(-1);
        }
    }

    @Override
    public String toString() {
        return "PropertyParser{" +
                "props=" + props +
                '}';
    }
}
