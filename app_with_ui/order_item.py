from product import Product


class OrderItem:
    """ * Класс OrderItem представляет элемент заказа. Элемент заказа включает в себя товар
 * и количество этого товара в заказе.
 *
 * В контексте паттерна "Агрегатор", данный класс является одним из составных частей заказа (Order).
 * Он служит для представления информации о конкретном товаре и его количестве в заказе.
    """

    def __init__(self, product: Product, quantity: int):
        """
        Инициализирует объект класса OrderItem с указанным товаром и количеством.

        Аргументы:
            product (Product): Объект товара, связанный с элементом заказа.
            quantity (int): Количество товара в заказе.
        """
        self.product = product
        self.quantity = quantity

    def get_product(self) -> Product:
        """
        Возвращает товар, связанный с элементом заказа.

        Возвращаемое значение:
            Product: Объект товара.
        """
        return self.product

    def set_product(self, product: Product) -> None:
        """
        Устанавливает товар, связанный с элементом заказа.

        Аргументы:
            product (Product): Новый объект товара для установки.
        """
        self.product = product

    def get_quantity(self) -> int:
        """
        Возвращает количество товара в заказе.

        Возвращаемое значение:
            int: Количество товара.
        """
        return self.quantity
