package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository{

    private DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findById(Long id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = " + id + ";";

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        return new User(resultSet.getLong("id"), resultSet.getString("email"));
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> usersList = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM users ;");

        while (resultSet.next()) {
            usersList.add(new User( resultSet.getLong("id"), resultSet.getString("email") ));
        }

        return usersList;
    }

    @Override
    public void save(User entity) throws SQLException {
        String query = "INSERT INTO users(id, email) values ("
                + entity.getId()
                + ", '" + entity.getEmail() + "') ;";

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        statement.execute(query);
    }

    @Override
    public void update(User entity) throws SQLException {
        String request = "UPDATE users SET email = " + "'" + entity.getEmail() + "'" +
                " WHERE id = " + entity.getId() + " ;";

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(request);

        preparedStatement.execute();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String request = "DELETE FROM users WHERE id = " + id + " ;";

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(request);

        preparedStatement.execute();
    }

    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        String request = "SELECT * FROM users WHERE email = '" + email + "' ;";
        ResultSet resultSet = statement.executeQuery(request);

        return Optional.of(new User(resultSet.getLong("id"), resultSet.getString("email")));
    }
}
