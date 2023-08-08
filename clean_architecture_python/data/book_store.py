from abc import ABC, abstractmethod

class BookStore(ABC):
    """Абстрактный класс для работы с данными о книге

    Args:
    - ABC (): Вспомогательный класс, предоставляющий стандартный способ создания ABC с использованием наследования

    Raises:
    - NotImplementedError: В дочернем классе должна быть переопределена функция add_book()
    - NotImplementedError: В дочернем классе должна быть переопределена функция delete_book()
    - NotImplementedError: В дочернем классе должна быть переопределена функция get_all_book()
    """

    @abstractmethod
    def add_book(self):
        """Сохраняет данные о книге

        Raises:
        - NotImplementedError: В дочернем классе должна быть переопределена функция add_book()
        """
        raise NotImplementedError('В дочернем классе должна быть переопределена функция add_book()')

    @abstractmethod
    def delete_book(self):
        """Удаляет данные о книге

        Raises:
        - NotImplementedError: В дочернем классе должна быть переопределена функция delete_book()
        """
        raise NotImplementedError('В дочернем классе должна быть переопределена функция delete_book()')

    @abstractmethod
    def get_all_books(self):
        """Возвращает полный список всех книг и их данные

        Raises:
        - NotImplementedError: В дочернем классе должна быть переопределена функция get_all_book()
        """
        raise NotImplementedError('В дочернем классе должна быть переопределена функция get_all_book()')