import sys

sys.path.append(
    'c:\\Users\\Huawei\\OneDrive\\Документы\\Study\\Study\\Software_architecture\\clean_architecture_python\\data')
sys.path.append(
    'c:\\Users\\Huawei\\OneDrive\\Документы\\Study\\Study\\Software_architecture\\clean_architecture_python\\domain')


from book import Book
from sqllite_book_repository import SQLiteBookRepository
from in_memory_book_repository import InMemoryBookRepository



def run_memory() -> None:
    """Точка входа в приложение по работе с книгами через память ПК

    1. Создаем объект типа InMemoryBookRepository()
    2. Инициализируем объект класса Book через его конструктор
    3. Осуществляем манипуляции с объектами типа Book через объект типа InMemoryBookRepository
    """
    memory_store = InMemoryBookRepository()

    book_1 = Book(id=1, title='Война и мир',
                author='Толстой Л.Н.', price=798.99)
    book_2 = Book(id=2, title='Кэрри', author='Стивен Кинг', price=349.50)
    book_3 = Book(id=3, title='Бесприданница',
                author='Островский А.Н.', price=324.99)

    memory_store.add_book(book_1)
    memory_store.add_book(book_2)
    memory_store.add_book(book_3)

    all_memory_books = memory_store.get_all_books()
    for book in all_memory_books:
        print(f"ID: {book.get_id()}, Title: {book.get_title()}, Author: {book.get_author()}, Price: {book.get_price()}", sep=', ')

def run_db() -> None:
    """Точка входа в приложение по работе с книгами через базу данных SQLite3

    1. Создаем объект типа SQLiteBookRepositor()
    2. Инициализируем объект класса Book через его конструктор
    3. Осуществляем манипуляции с объектами типа Book через объект типа SQLiteBookRepositor
    """
    db_store = SQLiteBookRepository('books.db')
    book_4 = Book(id=4,
                title='Трагедии',
                author='Вильям Шекспир',
                price=759.50)
    book_5 = Book(id=5,
                title='Мертвые души', 
                author='Гоголь Н.В.',
                price=192)
    book_6 = Book(id=6, 
                title='Братья Карамазовы',
                author='Достоевский Ф.М.',
                price=607.50)
    book_7 = Book(id=7, 
                title='Маскарад',
                author='Лермонтов М.Ю.', 
                price=194.80)

    db_store.add_book(book_4)
    db_store.add_book(book_5)
    db_store.add_book(book_6)
    db_store.add_book(book_7)

    books = db_store.get_all_books()
    for book in books:
        print(book)
    
    db_store.drop_table()

    
if __name__ == '__main__':
    run_memory()
    run_db()