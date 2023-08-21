package org.example.cqr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс "GetAllUsersQuery".
 * Отвечает за извлечение списка пользователей из базы данных.
 * Реализует интерфейс Query<List<String>>.
 */
public class GetAllUsersQuery implements Query<List<String>> {

    // Соединение с базой данных
    private final Connection connection;

    /**
     * Конструктор.
     *
     * @param connection Соединение с базой данных.
     */
    public GetAllUsersQuery(Connection connection) {
        this.connection = connection;
    }

    /**
     * Выполняет запрос на извлечение всех пользователей из базы данных.
     *
     * @return Список имен пользователей.
     */
    @Override
    public List<String> execute() {
        List<String> users = new ArrayList<>();
        String sql = "SELECT name FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                users.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}