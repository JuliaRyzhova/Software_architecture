"""НЕобходимо исправить нарушение 2-го принципа SOLID OCP"""

"""Open-closed principle - Принцип открытости\закрытости. Классы должны быть открыты для расширения и закрыты для модификации. 
Т.е. должна быть возможность добавлять новый свойства и расширять класс без изменения внутренней реализации существующих 
свойств."""


class Greeting:
    def __init__(self, type):
        self.type = type

    def greet(self):
        if self.type == "formal":
            print("Добро пожаловать, уважаемый гость!")
        elif self.type == "informal":
            print("Привет, друг!")


if __name__ == "__main__":
    greeting = Greeting("informal")
    greeting.greet()
