class Product:
    """ * Класс Product представляет товар, который может быть добавлен в заказ.
        * Этот класс содержит информацию о товаре, такую как идентификатор, название, стоимость и количество.
    """

    def __init__(self, id: int, name: str, price: float, count: int):
        """
        Инициализирует объект Product.

        Аргументы:
            id (int): Идентификатор товара.
            name (str): Название товара.
            price (float): Стоимость товара.
            count (int): Количество товара.
        """
        self.id = id
        self.name = name
        self.price = price
        self.count = count

    def __str__(self) -> str:
        """
        Возвращает строковое представление товара.

        Возвращает:
            str: Строковое представление товара.
        """
        return "id = {}, название = '{}', цена = {}, количество = {}".format(self.id, self.name, self.price, self.count)

    def __hash__(self) -> int:
        """
        Возвращает хэш-код товара.

        Возвращает:
            int: Хэш-код товара.
        """
        return hash((self.id, self.name, self.price, self.count))

    def __eq__(self, other) -> bool:
        """
        Проверяет равенство данного товара с другим товаром.

        Аргументы:
            other (Product): Другой товар для сравнения.

        Возвращает:
            bool: Результат проверки равенства товаров.
        """
        if isinstance(other, Product):
            return (self.id, self.name, self.price, self.count) == (other.id, other.name, other.price, self.count)
        return False
