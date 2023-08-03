from shape_view import ShapeView

class SquareView(ShapeView):
    """Класс представления параметров квадрата в консоли, наследник абстрактного класса ShapeView

    Методы:
    - show_area(area: float): Метод для вывода площади квадрата в консоль
    - show_perimeter(perimeter: float): Метод для вывода периметра квадрата в консоль
    - show_value_error(): Метод для вывода ошибки некорректного значения стороны квадрата
    """
    def show_area(self, area:float) ->None:
        """Метод для вывода площади квадрата в консоль

        Args:
            area (float): площадь квадрата
        """
        print(f'Площадь квадрата + {area}')

    def show_perimeter(self, perimeter: float) -> None:
        """Метод для вывода периметра квадрата в консоль

        Args:
            perimeter (float): периметр квадрата
        """
        print(f'Периметр квадрата + {perimeter}')

    def show_value_error() -> None:
        """Метод для вывода ошибки некорректного значения длины стороны квадрата
        """
        print("Ошибка: некорректное значение стороны квадрата! Сторона квадрата должна быть положительным числом")
