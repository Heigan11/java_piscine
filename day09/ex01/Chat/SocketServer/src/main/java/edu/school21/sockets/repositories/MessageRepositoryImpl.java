package edu.school21.sockets.repositories;

import edu.school21.sockets.models.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Component("messageRepository")
public class MessageRepositoryImpl implements MessageRepository{

    private JdbcTemplate jdbcTemplate;

    public MessageRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Message> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Message> findAll() {
        return null;
    }

    @Override
    public void save(Message entity) {
        jdbcTemplate.update("INSERT INTO messages(author, text, time) VALUES (?, ?, ?);",
                entity.getAuthor().getId(), entity.getText(), Timestamp.valueOf(entity.getTime()));
    }

    @Override
    public void update(Message entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
