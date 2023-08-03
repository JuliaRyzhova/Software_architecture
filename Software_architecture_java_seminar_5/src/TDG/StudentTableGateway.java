package TDG;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTableGateway {
    // Соединение с базой данных
    private Connection conn;

    public StudentTableGateway(Connection conn) {
        this.conn = conn;
    }

    public ResultSet findAll() throws SQLException {
        // Здесь мы формируем SQL запрос на получение всех записей из таблицы студентов.
        String sql = "SELECT * FROM students";
        Statement statement = conn.createStatement();
        return statement.executeQuery(sql);
    }

    public void insert(int id, String name, String course) throws SQLException {
        // Здесь мы формируем SQL запрос на вставку новой записи в таблицу студентов.
        String sql = String.format("INSERT INTO students (id, name, course) VALUES (%d, '%s', '%s')", id, name, course);
        Statement statement = conn.createStatement();
        statement.execute(sql);
    }

    public void update(int id, String name, String course) throws SQLException {
        // Здесь мы формируем SQL запрос на обновление записи в таблице студентов.
        String sql = String.format("UPDATE students SET name = '%s', course = '%s' WHERE id = %d", name, course, id);
        Statement statement = conn.createStatement();
        statement.execute(sql);
    }

    public void delete(int id) throws SQLException {
        // Здесь мы формируем SQL запрос на удаление записи из таблицы студентов.
        String sql = String.format("DELETE FROM students WHERE id = %d", id);
        Statement statement = conn.createStatement();
        statement.execute(sql);
    }
}