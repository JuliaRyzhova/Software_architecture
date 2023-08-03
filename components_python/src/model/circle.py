from math import pi
from src.model.shape import Shape


class Circle(Shape):
    """Класс геометрической фигуры 'Круг' наследник класса 'Shape'

    Атрибуты:
        __radius (float): радиус круга (должен быть положительным числом)
    Методы:
    - __init__(radius: float): конструктор класса Circle
    - __check_value(radius: float) -> bool: проверяет корректность введенных данных
    - get_radius() -> float: возвращает радиус круга
    - set_radius(radius: float): устанавливает радиус круга
    - calculate_area() -> float: вычисляет площадь круга
    - calculate_perimeter() -> float: вычисляет периметр круга
    """

    def __init__(self, radius: float) -> None:
        """Конструктор - создание нового экземпляра класса Circle

        Args:
        - radius (float): радиус круга (должен быть положительным числом)
        """
        if self.__check_value(radius):
            self.__radius = radius

    @staticmethod
    def __check_value(radius: float) -> bool:
        """Проверяет корректность введенных данных

        Returns:
            True - если радиус >0
            False - если радиус <0 или не число
        """
        return isinstance(radius, (int, float)) and radius >= 0

    def get_radius(self) -> float:
        """Доступ к полю radius объекта класса Circle. Возвращает радиус

        Returns:
            radius(float): радиус круга (тип float)
        """
        return self.__radius

    def set_radius(self, radius: float) -> None:
        """
        Устанавливает значение радиуса круга.

        Args:
            - radius: числовое значение радиуса круга

        Возможные исключения:
            - ValueError: выбрасывается, если radius не является типом int или float, либо <=0
        """
        if self.__check_value(radius):
            self.__radius = radius
        else:
            raise ValueError("Радиус должен быть положительным числом")

    def calculate_area(self) -> float:
        """Расчитывает площадь круга

        Returns:
           float: площадь круга (тип float)

        """
        return pi * (self.__radius ** 2)

    def calculate_perimeter(self) -> float:
        """Расчитывает периметр круга

        Returns:
           float: периметр круга (тип float)
        """
        return 2 * pi * self.__radius

