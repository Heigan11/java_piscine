package edu.school21.sockets.services;

import java.sql.SQLException;

public interface MessageService {
    void save(String username, String text) throws SQLException;
}
