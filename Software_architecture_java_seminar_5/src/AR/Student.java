package AR;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    private int id;
    private String name;
    private String course;
    // Соединение с базой данных
    private Connection conn;

    public Student(int id, String name, String course, Connection conn) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.conn = conn;
    }

    // Геттеры и сеттеры...

    public void insert() throws SQLException {
        // Здесь мы формируем SQL запрос на вставку данных об объекте в базу данных.
        String sql = String.format("INSERT INTO students (id, name, course) VALUES (%d, '%s', '%s')", id, name, course);
        try(Statement statement = conn.createStatement()){
            statement.execute(sql);
        }
    }

    public void update() throws SQLException {
        // Здесь мы формируем SQL запрос на обновление данных об объекте в базе данных.
        String sql = String.format("UPDATE students SET name = '%s', course = '%s' WHERE id = %d", name, course, id);
        try(Statement statement = conn.createStatement()){
            statement.execute(sql);
        }
    }

    public void delete() throws SQLException {
        // Здесь мы формируем SQL запрос на удаление данных об объекте из базы данных.
        String sql = String.format("DELETE FROM students WHERE id = %d", id);
        try(Statement statement = conn.createStatement()){
            statement.execute(sql);
        }
    }

    // Бизнес-логика
    public boolean isEligibleForScholarship() {
        // Допустим, что студенты, обучающиеся на определенных курсах, имеют право на стипендию.
        return course.equals("Mathematics") || course.equals("Physics");
    }
}