class Book:

    def __init__(self, title, author):
        self.__title = title
        self.__author = author

    # Геттеры
    def get_title(self):
        return self.__title

    def get_author(self):
        return self.__author
