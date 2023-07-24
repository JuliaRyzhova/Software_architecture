# Абстрактный класс для формы
class Shape:
    def __init__(self, color):
        self.color = color

    def apply_color(self):
        pass

# Конкретная реализация формы - Круг


class Circle(Shape):
    def apply_color(self):
        print(f"Circle filled with color {self.color.apply_color()}")

# Конкретная реализация формы - Квадрат


class Square(Shape):
    def apply_color(self):
        print(f"Square filled with color {self.color.apply_color()}")

# Абстрактный класс для цвета


class Color:
    def apply_color(self):
        pass

# Конкретная реализация цвета - Красный


class RedColor(Color):
    def apply_color(self):
        return "Red"

# Конкретная реализация цвета - Зеленый


class GreenColor(Color):
    def apply_color(self):
        return "Green"


if __name__ == "__main__":
    # Создание объектов форм и цветов
    red_circle = Circle(RedColor())
    green_square = Square(GreenColor())

    # Применение цветов к формам
    red_circle.apply_color()   # Выведет: "Circle filled with color Red"
    green_square.apply_color()  # Выведет: "Square filled with color Green"
