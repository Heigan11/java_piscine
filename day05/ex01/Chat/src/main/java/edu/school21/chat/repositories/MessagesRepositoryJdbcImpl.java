package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM chat_messages WHERE messageId = " + id;
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

//        Message message = new Message(
//                resultSet.getLong("messageId"),
//                new User(resultSet.getLong("messageAuthor"), "user1", "111", null, null),
//                new Chatroom(resultSet.getLong("messageRoom"), "chat1", null, null),
//                resultSet.getString("messageText"),
//                resultSet.getTimestamp("messageTime").toLocalDateTime() );
////                resultSet.getTimestamp("messageTime") != null ? resultSet.getTimestamp("messageTime").toLocalDateTime() : null );
//
//        System.out.println(message);

        return Optional.of(
                new Message(
                        resultSet.getLong("messageId"),
                        new User(resultSet.getLong("messageAuthor"), "user1", "111", null, null),
                        new Chatroom(resultSet.getLong("messageRoom"), "chat1", null, null),
                        resultSet.getString("messageText"),
                        resultSet.getTimestamp("messageTime").toLocalDateTime()
                )
        );
    }
}
