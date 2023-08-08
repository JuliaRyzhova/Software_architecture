from typing import List
import sqlite3 as sq

import sys
sys.path.append(
    'c:\\Users\\Huawei\\OneDrive\\Документы\\Study\\Study\\Software_architecture\\clean_architecture_python\\domain')

from book import Book
from book_store import BookStore



class SQLiteBookRepository(BookStore):
    """Класс реализующий функционал управления данными о книге с помощью базы данные SQLite3

    Args:
    - BookStore (): Абстрактный класс для работы с данными о книге

    Методы:
    - __init__() - Конструктор создания экземпляра класса, устанавливает подключение к БД и создает новую, в случае ее отсутствия
    - add_book(book: Book) - Добавляет данные о книге в БД
    - delete_book(book: Book) - Удаляет данные о книге из БД
    - get_all_books(): List[Book] - Возвращает список всех книг из БД

    """
    def __init__(self, db_path: str) -> None:
        """Конструктор создания экземпляра класса, устанавливает подключение к БД и создает новую, в случае ее отсутствия

        Args:
        - db_path (строка): Путь к базе данных SQLite

        """
        self.db_path = db_path
        with sq.connect(self.db_path) as connection:
            cur = connection.cursor()
            cur.execute("""CREATE TABLE IF NOT EXISTS books(
                        id INTEGER UNIQUI PRIMARY KEY,
                        title TEXT NOT NULL,
                        author TEXT NOT NULL,
                        price REAL NOT NULL);
                        """)


    def add_book(self, book: Book) -> None:
        """Добавляет объект класса Book в базу данных SQLite

        Args:
        - book (Book) - объект класса Book
        """
        with sq.connect(self.db_path) as connection:
            cur = connection.cursor()
            cur.execute("""INSERT INTO books (id, title, author, price) VALUES (?, ?, ?, ?)""",
                        (book.get_id(), book.get_title(), book.get_author(), book.get_price()))


    def delete_book(self, book:Book) ->None:
        """Удаляет объект класса Book из базы данных SQLite

        Args:
        - book (Book) - объект класса Book
        """
        with sq.connect(self.db_path) as connection:
            cur = connection.cursor()
            cur.execute("""DELETE FROM books WHERE id = ?""", book.get_id())


    def get_all_books(self) -> List[Book]:
        """Возвращает список всех книг из БД

        Returns:
        - List[Book] - список объектов класса Book
        """
        with sq.connect(self.db_path) as connection:
            cur = connection.cursor()
            cur.execute("""SELECT * FROM books""")
            result = cur.fetchall()
            books = []
            for row in result:
                book = Book(row[0], row[1], row[2], row[3])
                books.append(book)
            return books
        
    def drop_table(self) -> None:
        """Удаляет базу данных если она создана
        """
        with sq.connect(self.db_path) as connection:
            cur = connection.cursor()
            cur.execute("""DROP TABLE IF EXISTS books""")