package school21.app;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

public class Program {

    private static final String PACKAGE_NAME = "school21.models.";
    private EmbeddedDatabase dataSourse;

    public static void main(String[] args) {
        Program program = new Program();
        program.dataSourse = new EmbeddedDatabaseBuilder().build();
    }
}
