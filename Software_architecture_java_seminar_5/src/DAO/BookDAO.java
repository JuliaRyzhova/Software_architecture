package DAO;

import java.util.List;

// Интерфейс BookDAO определяет операции, которые мы хотим поддерживать для доступа к данным книг.
public interface BookDAO {
    List<Book> getAllBooks();
    Book getBook(String isbn);
    void updateBook(Book book);
    void deleteBook(Book book);
}

// Класс Book представляет объект данных книги.
class Book {
    private String isbn;
    private String title;
    private String author;
    // методы getters и setters здесь
}

// Реализация BookDAO для работы с базой данных SQL.
class BookDAOImpl implements BookDAO {
    private Connection dbConnection;

    public BookDAOImpl(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public List<Book> getAllBooks() {
        // Здесь мы используем dbConnection для получения всех книг из базы данных и возвращаем их как список объектов Book.
    }

    @Override
    public Book getBook(String isbn) {
        // Здесь мы используем dbConnection для получения книги с заданным ISBN из базы данных и возвращаем её как объект Book.
    }

    @Override
    public void updateBook(Book book) {
        // Здесь мы используем dbConnection и данные объекта book для обновления книги в базе данных.
    }

    @Override
    public void deleteBook(Book book) {
        // Здесь мы используем dbConnection и данные объекта book для удаления книги из базы данных.
    }
}