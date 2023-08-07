from abstract_user_repo import AbstractUserRepository
from user_exception import UserNotFoundException
from user import User

class UserRepository(AbstractUserRepository):
    """Класс, представляющий репозиторий пользователей

        Атрибуты:
        - users (list): список пользователей

        Методы:
    
        - save_user(user: User) - Сохраняет пользователя
        - find_by_id(user_id: int): User - Ищет пользователя по Id
        - find_by_name(name: str): User - Ищет пользователя по имени
        - delete_user(user: User) - Удаляет пользователя
        - find_all(): list - Находит всех пользователей """

    def __init__(self) -> None:
        self.users = []

    def find_by_id(self, id: int) -> User:
        """Найти пользователя по его идентификатору

        Параметры:
        - id (int): идентификатор пользователя

        Возвращает:
        - user (User): найденный пользователь

        Исключения:
        - UserNotFoundException: если пользователь с указанным id не найден"""
        for user in self.users:
            if user.get_id() == id:
                return user
        raise UserNotFoundException(f"Пользователь с id {id} не найден")

    def save_user(self, user: User) -> None:
        """Добавить пользователя в репозиторий

        Параметры:
        - user (User): пользователь для добавления
        """
        self.users.append(user)

    def delete_user(self, user: User) -> None:
        """Удалить пользователя из репозитория

        Параметры:
        - user (User): пользователь для удаления"""
        self.users.remove(user)

    def find_by_name(self, name: str) -> list:
        """ Найти пользователей по имени

        Параметры:
        - name (str): имя пользователя для поиска

        Возвращает:
        - foundusers (list): список найденных пользователей с указанным именем"""
        foundusers = []
        for user in self.users:
            if user.get_name() == name:
                foundusers.append(user)
        return foundusers

    def find_all(self) -> list:
        """
        Найти всех пользователей в репозитории

        Возвращает:
        - users (list): список всех пользователей
        """
        return self.users