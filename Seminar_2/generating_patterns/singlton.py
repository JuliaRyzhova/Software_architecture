class Singleton:
    # Статическое поле для хранения единственного экземпляра класса
    _instance = None

    # Приватный конструктор, чтобы предотвратить создание экземпляров извне класса
    def __init__(self):
        if Singleton._instance is not None:
            raise ValueError(
                "Этот класс - Singleton, используйте метод getInstance() для получения экземпляра.")
        Singleton._instance = self

    # Статический метод для получения единственного экземпляра класса
    @staticmethod
    def get_instance():
        if Singleton._instance is None:
            Singleton()
        return Singleton._instance

    # Дополнительные методы и свойства класса (необязательно)
    def do_something(self):
        print("Вызван метод do_something()")


    # Использование Одиночки
singleton1 = Singleton.get_instance()
singleton1.do_something()  # Выведет: "Вызван метод do_something()"

singleton2 = Singleton.get_instance()
singleton2.do_something()  # Выведет: "Вызван метод do_something()"
