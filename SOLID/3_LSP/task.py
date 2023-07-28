"""Необходимо исправить нарушение 3-го принципа SOLID LSP"""

"""Liskov substitution principle - Принцип подстановки Лескова. 
Подклассы должны заменять свои базовые классы. Дочерний класс должен полностью повторять функционал своего базового класса. 
Т.е. мы можем через дочерний класс вызвать любой метод базового класса и ожидать от него точно такого же поведения, 
какое у него было если мы его вызываем непосредственно из базового класса."""


class Rectangle:
    def __init__(self):
        self.width = 0
        self.height = 0

    def set_width(self, width):
        self.width = width

    def set_height(self, height):
        self.height = height

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def get_area(self):
        return self.width * self.height


class Square(Rectangle):
    def set_width(self, width):
        super().set_width(width)
        super().set_height(width)

    def set_height(self, height):
        super().set_width(height)
        super().set_height(height)


if __name__ == "__main__":
    rect = Square()
    rect.set_width(5)
    rect.set_height(10)
    print(rect.get_area())  # выводит 50
