package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariDataSource.setUsername("postgres");
        hikariDataSource.setPassword("123");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        Optional<Message> optionalMessage = repository.findById(1L);

        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            System.out.println(message.getData());
            System.out.println(message.getTime());
            message.setData("UPDATED");
            message.setTime(null);
            repository.update(message);
        }
        System.out.println(repository.findById(1L).get().getData());
        System.out.println(repository.findById(1L).get().getTime());
    }
}
