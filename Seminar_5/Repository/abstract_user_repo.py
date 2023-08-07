from abc import ABC, abstractmethod


class AbstractUserRepository(ABC):
    """ Абстрактный класс Репозитория
    
    Атрибуты:
    - users (list): список пользователей
    
    Методы:
    - save_user(user) - Сохраняет пользователя
    - find_by_id(user_id) - Ищет пользователя по Id
    - find_by_name(name) - Ищет пользователя по имени
    - delete_user(user) - Удаляет пользователя
    - find_all() - Находит всех пользователей  """

    @abstractmethod
    def save_user(self, user):
        """Сохраняет пользователя"""
        pass

    @abstractmethod
    def find_by_id(self, user_id):
        """Ищет пользователя по Id"""
        pass

    def find_by_name(self, name):
        """Ищет пользователя по имени"""
        pass

    @abstractmethod
    def delete_user(self, user):
        """Удаляет пользователя"""
        pass

    def find_all(self):
        """Возвращает всех пользователей"""
        pass
