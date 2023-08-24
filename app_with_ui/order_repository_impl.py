import sqlite3
from typing import List
from order_repository import OrderRepository
from product import Product
from order import Order
from order_item import OrderItem


class OrderRepositoryImpl(OrderRepository):
    """Реализация репозитория заказов, использующая базу данных SQLite."""

    def __init__(self, database_name):
        """
        Инициализирует объект OrderRepositoryImpl с указанным именем базы данных.

        Аргументы:
            database_name (str): Имя базы данных SQLite.
        """
        self.conn = sqlite3.connect(database_name)
        self.cursor = self.conn.cursor()
        self.init_database()

    def init_database(self) -> None:
        """Инициализирует базу данных, создавая необходимые таблицы при их отсутствии."""
        create_table = '''
        CREATE TABLE IF NOT EXISTS products (
            id INTEGER PRIMARY KEY,
            name TEXT,
            price REAL,
            count INTEGER
        );
        CREATE TABLE IF NOT EXISTS orders (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            total_amount REAL
        );
        CREATE TABLE IF NOT EXISTS order_items (
            order_id INTEGER,
            product_id INTEGER,
            quantity INTEGER,
            FOREIGN KEY (product_id, order_id) REFERENCES products (id, order_id)
        );
    '''
        with self.conn:
            cursor = self.conn.cursor()
            cursor.executescript(create_table)

    def add_product(self, product: Product) -> None:
        """
        Добавляет товар в таблицу 'products' базы данных.

        Аргументы:
            product (Product): Объект товара для добавления.
        """
        try:
            with self.conn:
                self.cursor.execute(
                    '''
                INSERT INTO products (id, name, price, count) VALUES (?, ?, ?, ?)
                ''',
                    (product.id, product.name, product.price, product.count)
                )
                print('Товар добавлен')
        except sqlite3.Error as e:
            print("Ошибка при добавлении товара в таблицу 'products':", e)

    def save(self, order: Order, order_items: List[OrderItem]) -> None:
        """
        Сохраняет заказ и элементы заказа в базе данных.

        Аргументы:
            order (Order): Объект заказа для сохранения.
            order_items (List[OrderItem]): Список объектов элементов заказа для сохранения.
        """
        try:
            with self.conn:
                self.cursor.execute(
                    '''INSERT INTO orders(id, total_amount) VALUES (Null, ?)''', (order.get_total_price(order_items),))
                generated_id = self.cursor.lastrowid
            with self.conn:
                for order_item in order_items:
                    self.cursor.execute(
                        '''INSERT INTO order_items(order_id, product_id, quantity) VALUES (?, ?, ?)''', (
                            generated_id,
                            order_item.get_product().id,
                            order_item.get_quantity()))

            print('Заказ сохранен')
        except sqlite3.Error as e:
            print("Ошибка при сохранении заказа:", e)

    def get_last_order(self) -> None:
        """
        Выводит информацию о последнем заказе в базе данных.
        """
        try:
            with self.conn:
                result = self.cursor.execute(
                    '''SELECT * FROM orders ORDER BY id DESC LIMIT 1'''
                )
                print(result.fetchone())
        except sqlite3.Error as e:
            print("Ошибка при выводе последнего заказа:", e)
