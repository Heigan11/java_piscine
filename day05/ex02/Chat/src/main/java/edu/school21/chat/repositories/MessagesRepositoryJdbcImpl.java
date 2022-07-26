package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
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

    @Override
    public void save(Message message) {
        String query = "INSERT INTO chat_messages(messageAuthor, messageRoom, messageText, messageTime) values ("
                + message.getSender().getId()
                + ", " + message.getRoom().getId()
                + ", '" + message.getData()
                + "', '" + message.getTime() + "');";

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            statement.execute(query);

            String messageIdFromDB = "select messageId from chat_messages order by messageId desc limit 1";

            ResultSet resultSet = statement.executeQuery(messageIdFromDB);
            resultSet.next();
            message.setId(resultSet.getLong("messageId"));

        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Entity are not saved");
        }
    }
}
