from abc import ABC, abstractmethod
class BookRepository(ABC):
    """Абстрактный метод хранилища книг"""

    @abstractmethod
    def add_book(self):
        raise NotImplementedError('В дочернем классе должна быть реализована функция add_book()')
    
    @abstractmethod
    def get_all_books(self):
        raise NotImplementedError('В дочернем классе должна быть реализована функция get_all_books()')
    
    @abstractmethod
    def update_book(self):
        raise NotImplementedError('В дочернем классе должна быть реализована функция update_book()')
    
    @abstractmethod
    def delete_book(self):
        raise NotImplementedError('В дочернем классе должна быть реализована функция delete_book()')