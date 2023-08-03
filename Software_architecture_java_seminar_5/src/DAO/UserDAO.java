import java.sql.Connection;
import java.util.List;

// Интерфейс определяет операции, которые должен поддерживать DAO.
public interface UserDAO {
    List<User> getAllUsers();
    User getUser(int id);
    void updateUser(User user);
    void deleteUser(User user);
}

// Класс User представляет объект данных пользователя.
class User {
    private int id;
    private String name;
    // добавьте больше полей по мере необходимости

    // методы getters and setters здесь
}

// Имплементация UserDAO для работы с базой данных SQL.
class UserDAOImpl implements UserDAO {
    private Connection dbConnection;

    public UserDAOImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<User> getAllUsers() {
        // Используйте dbConnection для получения пользователей из базы данных
        // и верните их как список объектов User.
    }

    @Override
    public User getUser(int id) {
        // Используйте dbConnection для получения пользователя с заданным id из базы данных
        // и верните его как объект User.
    }

    @Override
    public void updateUser(User user) {
        // Используйте dbConnection и данные объекта user для обновления пользователя
        // в базе данных.
    }

    @Override
    public void deleteUser(User user) {
        // Используйте dbConnection и данные объекта user для удаления пользователя
        // из базы данных.
    }
}