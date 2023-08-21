package org.example.cqr;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Класс "CQRSExample".
 * Демонстрация применения паттерна CQRS.
 */
public class CQRSExample {

    public static void main(String[] args) {
        // URL соединения с базой данных SQLite
        String url = "jdbc:sqlite:sample.db";

        try (Connection connection = DriverManager.getConnection(url)) {
            // Создание таблицы пользователей, если она не существует
            createUsersTable(connection);

            // Добавление пользователя
            Command addUser = new AddUserCommand(connection, "John Doe");
            addUser.execute();

            // Запрос всех пользователей
            Query<List<String>> query = new GetAllUsersQuery(connection);
            List<String> users = query.execute();

            // Вывод пользователей
            for (String user : users) {
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Создание таблицы пользователей, если она не существует.
     *
     * @param connection Соединение с базой данных.
     */
    private static void createUsersTable(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT NOT NULL)";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}