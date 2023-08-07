class User:
    """Класс, представляющий пользователя

        Атрибуты:
        - __id (int): идентификатор пользователя
        - __name (str): имя пользователя
        """

    def __init__(self, id: int, name: str) -> None:
        self.__id = id
        self.__name = name

    def get_id(self) -> int:
        """ Возвращает идентификатор пользователя """
        return self.__id

    def get_name(self) -> str:
        """ Возвращает имя пользователя """
        return self.__name
