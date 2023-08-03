from abc import ABC, abstractmethod

# Класс User представляет объект данных пользователя.
class User:
    def __init__(self, id, name):
        self.id = id
        self.name = name

# Абстрактный базовый класс определяет операции, которые должен поддерживать DAO.
class UserDAO(ABC):
    @abstractmethod
    def get_all_users(self):
        pass

    @abstractmethod
    def get_user(self, id):
        pass

    @abstractmethod
    def update_user(self, user):
        pass

    @abstractmethod
    def delete_user(self, user):
        pass

# Имплементация UserDAO для работы с базой данных SQL.
class UserDAOImpl(UserDAO):
    def __init__(self):
        self._users = []

    def get_all_users(self):
        return self._users

    def get_user(self, id):
        for user in self._users:
            if user.id == id:
                return user
        return None

    def update_user(self, user):
        for i, u in enumerate(self._users):
            if u.id == user.id:
                self._users[i] = user
                return
        raise ValueError("User not found")

    def delete_user(self, user):
        self._users = [u for u in self._users if u.id != user.id]