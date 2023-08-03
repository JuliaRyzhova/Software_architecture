package RDG;

import java.sql.Connection;

public class User {
    private int id;
    private String name;
    private String email;
    private Connection dbConnection;

    public User(int id, String name, String email, Connection dbConnection) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dbConnection = dbConnection;
    }

    // методы getters и setters здесь

    public void insert() {
        // Используйте dbConnection для вставки этой строки в базу данных
    }

    public void update() {
        // Используйте dbConnection для обновления этой строки в базе данных
    }

    public void delete() {
        // Используйте dbConnection для удаления этой строки из базы данных
    }
}