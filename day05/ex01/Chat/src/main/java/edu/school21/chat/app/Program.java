package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("123");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        System.out.print("Enter message ID\n");
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        if (repository.findById(id).isPresent()) {
            System.out.println(repository.findById(id).get());
        } else {
            System.out.println("No such message");
        }
    }
}
