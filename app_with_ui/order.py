from typing import List
from order_item import OrderItem
from product import Product


class Order:
    """* Класс Order представляет заказ, который состоит из одного или нескольких товаров (элементов заказа).
 * Этот класс агрегирует в себе несколько объектов OrderItem, что соответствует паттерну "Агрегатор".
 * В контексте паттерна "Агрегатор", данный класс играет роль "Контейнера", который собирает в себе
 * несколько объектов, предоставляя удобный интерфейс для работы с ними.
    """

    def __init__(self):
        """
        Инициализирует объект Order.
        """
        self.products: List[OrderItem] = []

    def add_product(self, product: Product) -> None:
        """
        Добавляет товар в заказ.

        Аргументы:
            product (Product): Продукт для добавления в заказ.
        """
        self.products.append(product)

    def remove_product(self, product: Product) -> None:
        """
        Удаляет товар из заказа.

        Аргументы:
            product (Product): Продукт для удаления из заказа.
        """
        self.products.remove(product)

    def get_total_price(self, products) -> float:
        """
        Возвращает общую стоимость всех товаров в заказе.

        Возвращает:
            float: Общая стоимость заказа.
        """
        total_price = 0
        for item in products:
            item_price = item.get_product().price * item.get_quantity()
            total_price += item_price
        return total_price

    def __str__(self) -> str:
        """
        Возвращает строковое представление заказа.

        Возвращает:
            str: Строковое представление заказа.
        """
        product_strings = [str(product) for product in self.products]
        return f"Order ID: {self.order_id}\nProducts:\n{', '.join(product_strings)}"
