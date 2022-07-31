package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("usersRepository")
public class UsersRepositoryImpl implements UsersRepository{

    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> rowMapper = (user, rowMapper) ->
            new User(user.getLong(1), user.getString(2), user.getString(3));

    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ? ;", rowMapper, id)
                .stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users ;", rowMapper);
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users(username, password) VALUES (?, ?);", entity.getUsername(), entity.getPassword());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET username = ?, password = ? WHERE id = ?;", entity.getUsername(), entity.getPassword(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ? ;", id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jdbcTemplate.query("SELECT * FROM users WHERE username = ? ;", rowMapper, username).stream().findAny();
    }
}
