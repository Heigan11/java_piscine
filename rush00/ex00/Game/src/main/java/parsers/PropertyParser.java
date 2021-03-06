package parsers;

import models.Game;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyParser {

    private static Properties props;

    public static void setProperties() {
        try {
            InputStream is = PropertyParser.class.getResourceAsStream("/application-" + Game.getProfile() + ".properties");
            props = new Properties();
            props.load(is);
            assert is != null;
            is.close();
            if (props.getProperty("empty.char").isEmpty()) {
                props.setProperty("empty.char", " ");
            }
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
