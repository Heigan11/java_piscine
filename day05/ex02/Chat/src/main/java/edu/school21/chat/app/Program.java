package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("123");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        Message message = new Message(
                null,
                new User(1L, "user1", "111", null, null),
                new Chatroom(1L, "chat1", null, null),
               "messageText",
                LocalDateTime.now()
        );

        repository.save(message);

        System.out.println(repository.findById(message.getId()));
    }
}
