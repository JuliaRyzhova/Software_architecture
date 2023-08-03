package DAO_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

interface UserDao {
    List<User> getAllUsers();
    Optional<User> getUser(int id);
    void updateUser(User user);
    void deleteUser(User user);
}

class UserDaoImpl implements UserDao {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> getUser(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public void updateUser(User user) {
        getUser(user.getId()).ifPresent(existingUser -> {
            existingUser = user;
        });
    }

    @Override
    public void deleteUser(User user) {
        users.removeIf(existingUser -> existingUser.getId() == user.getId());
    }
}

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        userDao.getAllUsers().add(user1);
        userDao.getAllUsers().add(user2);

        userDao.getAllUsers().forEach(user -> {
            System.out.println(user.getName());
        });

        System.out.println(userDao.getUser(1).get().getName());

        userDao.updateUser(new User(1, "Alicia"));
        System.out.println(userDao.getUser(1).get().getName());

        userDao.deleteUser(user1);
        userDao.getAllUsers().forEach(user -> {
            System.out.println(user.getName());
        });
    }
}