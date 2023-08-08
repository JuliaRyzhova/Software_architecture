class Book:
    """Класс объекта 'Книга'

    Атрибуты:
    - __id(int) - Индентификатор книги
    - __title(str) - Название книги
    - __author(str) - Автор книги
    - __price(float) - Цена за 1 экземпляр

    Методы:
    - get_id(): int - Возвращает идентификатор книги
    - set_id(id: int) - Устанавливает новый идентификатор книги
    - get_title(): str - Возвращает название книги
    - set_title(title: str) - Устанавливает новое название книги
    - get_author(): str - Возвращает автора книги
    - set_author(author: str) - Устанавливает нового автора книги
    - get_price(): float - Возвращает цену за 1 экземпляр книги
    - set_price(price: float) - Устанавливает цену за 1 экземпляр книги
    - __str__(): str - Переопределение текстового представления объекта"""

    def __init__(self, id: int, title: str, author: str, price: float) -> None:
        """Конструктор для создания экземпляра класса 

        Args:
        - id (int): Индентификатор книги
        - title (str): Название книги
        - author (str): Автор книги
        - price (float): Цена за 1 экземпляр
        """
        self.__id = id
        self.__title = title
        self.__author = author
        self.__price = price

    def get_id(self) -> str:
        """Возвращает идентификатор книги

        Returns:
        - str: идентификатор книги
        """
        return self.__id

    def set_id(self, id: int) -> None:
        """Устанавливает новый идентификатор книги

        Args:
        - id (str): идентификатор книги
        """
        self.__id = id

    def get_title(self) -> str:
        """Возвращает название книги

        Returns:
        - str: название книги
        """
        return self.__title

    def set_title(self, title: str) -> None:
        """Устанавливает новое название книги

        Args:
        - title (str): название книги
        """
        self.__title = title

    def get_author(self) -> str:
        """Возвращает автора книги

        Returns:
        - str: автор книги
        """
        return self.__author

    def set_author(self, author: str) -> None:
        """Устанавливает нового автора книги

        Args:
        - author (str): автор книги
        """
        self.__author = author

    def get_price(self) -> float:
        """Возвращает цену за 1 экземпляр книги

        Returns:
        - float: цена за 1 экземпляр книги
        """
        return self.__price

    def set_price(self, price: float) -> None:
        """Устанавливает цену за 1 экземпляр книги

        Args:
        - price (float): цена за 1 экземпляр книги
        """
        self.__price = price

    def __str__(self) -> str:
        """Переопределение текстового представления объекта

        Returns:
        - str: Строка с текстовым представлением данных объекта
        """
        return f"ID: {self.__id}, Title: {self.__title}, Author: {self.__author}, Price: {self.__price}"
