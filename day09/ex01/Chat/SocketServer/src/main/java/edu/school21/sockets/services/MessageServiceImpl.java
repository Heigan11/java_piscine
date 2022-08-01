package edu.school21.sockets.services;

import edu.school21.sockets.models.Message;
import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.MessageRepository;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component("messageService")
public class MessageServiceImpl implements MessageService {

    private final UsersRepository usersRepository;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(UsersRepository usersRepository, MessageRepository messageRepository) {
        this.usersRepository = usersRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void save(String username, String text) throws SQLException {
        Optional<User> optionalUser = usersRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            Message message = new Message(null, optionalUser.get(), text, LocalDateTime.now());
            messageRepository.save(message);
        } else {
            System.err.println("Entity are not saved!");
        }
    }
}
