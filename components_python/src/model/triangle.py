from shape import Shape
from math import sqrt


class Triangle(Shape):
    """Класс геометрической фигуры 'Треугольник' наследник класса 'Shape'

    Атрибуты:
    - __side_1 (float): длина первой стороны треугольника (должна быть положительным числом)
    - __side_2 (float): длина второй стороны треугольника (должна быть положительным числом)
    - __side_3 (float): длина третьей стороны треугольника (должна быть положительным числом)

    Методы:
    - __init__(side_1: float, side_2: float, side_3: float): конструктор класса Triangle
    - __check_values(side_1: float, side_2: float, side_3: float) -> bool: проверяет корректность введенных данных
    - get_values() -> tuple: возвращает кортеж из длин трех сторон треугольника
    - set_values(side_1: float, side_2: float, side_3: float): устанавливает длины сторон треугольника
    - calculate_area() -> float: вычисляет площадь треугольника
    - calculate_perimeter() -> float: вычисляет периметр треугольника
    """

    def __init__(self, side_1: float, side_2: float, side_3: float) -> None:
        """Конструктор - создание нового экземпляра класса Triangle

        Args:
        - side_1 (float): длина первой стороны треугольника (должна быть положительным числом)
        - side_2 (float): длина второй стороны треугольника (должна быть положительным числом)
        - side_3 (float): длина третьей стороны треугольника (должна быть положительным числом)
        """
        if self.__check_values(side_1, side_2, side_3):
            self.__side_1 = side_1
            self.__side_2 = side_2
            self.__side_3 = side_3

    @staticmethod
    def __check_values(side_1: float, side_2: float, side_3: float) -> bool:
        """Проверяет корректность введенных данных

        Returns:
        - True - если длины сторон треугольника >0
        - False - если хотя бы одна из сторон треугольника <0 или не число
        """
        return (
            isinstance(side_1, (int, float)) and
            isinstance(side_2, (int, float)) and
            isinstance(side_3, (int, float)) and
            side_1 >= 0 and
            side_2 >= 0 and
            side_3 >= 0
        )

    def get_values(self) -> tuple:
        """Доступ к полям side_1, side_2, side_3 объекта класса Triangle. Возвращает длины сторон треугольника

        Returns:
            tuple: Кортеж со значениями длин сторон треугольника
        """
        return (
            self.__side_1,
            self.__side_2,
            self.__side_3
        )

    def set_values(self, side_1: float, side_2: float, side_3: float) -> None:
        """
        Устанавливает значения длин сторон треугольника.

        Args:
        - side_1 (float): длина первой стороны треугольника (должна быть положительным числом)
        - side_2 (float): длина второй стороны треугольника (должна быть положительным числом)
        - side_3 (float): длина третьей стороны треугольника (должна быть положительным числом)

        Возможные исключения:
            - ValueError: выбрасывается, если хотя бы одна из сторон треугольника <0 или не число
        """
        if self.__check_values(side_1, side_2, side_3):
            self.__side_1 = side_1
            self.__side_2 = side_2
            self.__side_3 = side_3
        else:
            raise ValueError(
                "Стороны треугольника должны быть положительными числами")

    def calculate_area(self):
        """Расчитывает площадь треугольника

        Returns:
           float: площадь треугольника (тип float)

        """
        s = (self.__side_1 + self.__side_2 + self.__side_3) / 2
        return sqrt*(s * (s - self.__side_1) * (s - self.__side_2) * (s - self.__side_3))

    def calculate_perimeter(self):
        """Расчитывает периметр треугольника

        Returns:
           float: периметр треугольника (тип float)

        """
        return self.__side_1 + self.__side_2 + self.__side_3
