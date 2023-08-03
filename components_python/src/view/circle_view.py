from shape_view import ShapeView


class CircleView(ShapeView):
    """Класс представления параметров круга в консоли, наследник абстрактного класса ShapeView

    Методы:
    - show_area(area: float): Метод для вывода площади круга в консоль
    - show_perimeter(perimeter: float): Метод для вывода периметра круга в консоль
    - show_radius_error(): Метод для вывода ошибки некорректного значения радиуса круга
    """

    def show_area(self, area: float) -> None:
        """Метод для вывода площади круга в консоль

        Args:
            area (float): площадь круга
        """
        print(f'Площадь круга + {area}')

    def show_perimeter(self, perimeter: float) -> None:
        """Метод для вывода периметра круга в консоль

        Args:
            perimeter (float): периметр круга
        """
        print(f'Периметр круга + {perimeter}')

    def show_radius_error() -> None:
        """Метод для вывода ошибки некорректного значения радиуса круга
        """
        print('Ошибка: некорректное значение радиуса круга! Радиус должен быть положительным числом')
