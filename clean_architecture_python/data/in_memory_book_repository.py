from typing import List
import sys

sys.path.append('c:\\Users\\Huawei\\OneDrive\\Документы\\Study\\Study\\Software_architecture\\clean_architecture_python\\data')
sys.path.append('c:\\Users\\Huawei\\OneDrive\\Документы\\Study\\Study\\Software_architecture\\clean_architecture_python\\domain')

from book_store import BookStore
from book import Book

class InMemoryBookRepository(BookStore):
    """Класс реализующий функционал управления данными о книге через память ПК

    Args:
        BookStore (): Абстрактный класс для работы с данными о книге

    Методы:
    - __init__() - Конструктор создания экземпляра класса, создает пустой список объектов типа Book
    - add_book(book: Book) - Добавляет данные о книге в список
    - delete_book(book: Book) - Удаляет данные о книге из списка
    - get_all_books(): List[Book] - Возвращает список всех книг
    """
    def __init__(self) -> None:
        """Конструктор экземпляра класса InMemoryBookRepository, создает пустой список объектов типа Book
        """
        self.books: List[Book] = []

    def add_book(self, book: Book) -> None:
        """Добавляет данные о книге в список

        Args:
        - book (Book): объект класса Book
        """
        self.books.append(book)

    def delete_book(self, book: Book) -> None:
        """Удаляет данные о книге из списка

        Args:
        - book (Book): объект класса Book
        """
        self.books.remove(book)

    def get_all_books(self) -> List[Book]:
        """Возвращает список всех книг

        Returns:
        - List[Book]: список объектов класса Book
        """
        return self.books
