package org.example.cqr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Класс "AddUserCommand".
 * Реализует добавление пользователя в базу данных.
 * Реализует интерфейс Command.
 */
public class AddUserCommand implements Command {

    // Соединение с базой данных
    private final Connection connection;
    // Имя пользователя
    private final String userName;

    /**
     * Конструктор.
     *
     * @param connection Соединение с базой данных.
     * @param userName Имя пользователя для добавления.
     */
    public AddUserCommand(Connection connection, String userName) {
        this.connection = connection;
        this.userName = userName;
    }

    /**
     * Выполнить добавление пользователя в базу данных.
     */
    @Override
    public void execute() {
        String sql = "INSERT INTO users (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, userName);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}