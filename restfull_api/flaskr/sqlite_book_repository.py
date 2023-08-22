import sqlite3

from book import Book
from book_repository import BookRepository

from config import app
from flask import g


class SQLiteBookRepository(BookRepository):
    """Хранение данных о сущности книга в БД SQLite"""

    def __init__(self):
        self.__db = self.connect_db()
        self.__cur = self.__db.cursor()

    def connect_db(self):
        """Соединяет с указанной базой данных."""
        conn = sqlite3.connect(app.config['DATABASE'])
        conn.row_factory = sqlite3.Row
        return conn

    def create_db(self):
        """Вспомогательная функция для создания таблиц БД"""
        db = self.connect_db()
        with app.open_resource('books.sql', mode='r') as f:
            db.cursor().execute(f.read())
        db.commit()
        db.close()

    def get_db(self):
        """Соединение с базой данных, если оно еще не установлено"""
        if not hasattr(g, 'link_db'):
            g.link_db = self.connect_db()
        return g.link_db

    def close_db(self):
        """Закрывает соединение с базой данных, если оно было установлено"""
        if hasattr(g, 'link_db'):
            g.link_db.close()
    
    def get_all_books(self):
        sql = "SELECT * FROM books LIMIT 100"
        try:
            self.__cur.execute(sql)
            result = self.__cur.fetchall()
            return result
        except sqlite3.Error as e:
            print("Ошибка чтения из БД:", str(e))
            return []

    def add_book(self, book: Book):
        sql = "INSERT INTO books VALUES(NULL, ?, ?, ?, ?, ?)"
        try:
            self.__cur.execute(sql, (book.title, book.author, book.price, book.count_book, book.year_release))
            self.__db.commit()
            return True
        except sqlite3.Error as e:
            print("Ошибка добавления книги в базу данных:", str(e))
            return False

    def update_book(self, book_id, price, count_book):
        sql = "UPDATE books SET price = ?, count_book = ? WHERE book_id = ?"
        try:
            self.__cur.execute(sql, (price, count_book, book_id))
            self.__db.commit()
            return True
        except sqlite3.Error as e:
            print("Ошибка обновления книги в базе данных:", str(e))
            return False

    def delete_book(self, book_id):
        sql = "DELETE FROM books WHERE book_id = ?"
        try:
            self.__cur.execute(sql, (book_id,))
            self.__db.commit()
            return True
        except sqlite3.Error as e:
            print("Ошибка удаления книги из базы данных:", str(e))
            return False