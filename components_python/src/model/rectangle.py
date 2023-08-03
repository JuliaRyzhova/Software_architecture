from shape import Shape


class Rectangle(Shape):
    """Класс геометрической фигуры 'Прямоугольник' наследник класса 'Shape'

    Атрибуты:
        __length (float): длина прямоугольника (должна быть положительным числом)
        __width (float): ширина прямоугольника (должна быть положительным числом)
    Методы:
    - __init__(length: float, width: float): конструктор класса Rectangle
    - __check_value(length, width) -> bool: проверяет корректность введенных данных
    - get_value() -> tuple: возвращает кортеж из длины и ширины прямоугольника
    - set_value(length: float, width: float): устанавливает длину и ширину прямоугольника
    - calculate_area() -> float: вычисляет площадь прямоугольника
    - calculate_perimeter() -> float: вычисляет периметр прямоугольника"""

    def __init__(self, length: float, width: float):
        """Конструктор - создание нового экземпляра класса Rectangle

        Args:
        - length (float): длина прямоугольника (должна быть положительным числом)
        - width (float): ширина прямоугольника (должна быть положительным числом)
        """
        if self.__check_value(length, width):
            self.__length = length
            self.__width = width

    @staticmethod
    def __check_value(length: float, width: float) -> bool:
        """Проверяет корректность введенных данных

        Returns:
            True - ширина и длина прямоугольника >0
            False - если ширина или длина прямоугольника <0 или не число
        """
        return isinstance(length, (int, float)) and isinstance(width, (int, float)) and (length >= 0) and (width >= 0)

    def get_value(self) -> tuple:
        """Доступ к полям length, width объекта класса Rectangle. Возвращает длину и ширину прямоугольника

        Returns:
            tuple: Кортеж со значениями длины и ширины прямоугольника
        """
        return (self.__length, self.__width)

    def set_value(self, length: float, width: float):
        """
        Устанавливает значения длины и ширины прямоугольника.

        Args:
            - length(float): числовое значение длины прямоугольника
            - width(float): числовое значение ширины прямоугольника

        Возможные исключения:
            - ValueError: выбрасывается, если длина или ширина прямоугольника не являются типом int или float, либо <=0
        """
        if self.__check_value(length, width):
            self.__length = length
            self.__width = width
        else:
            raise ValueError(
                "Ширина и длина прямоугольника должны быть положительными числами")

    def calculate_area(self) -> float:
        """Расчитывает площадь прямоугольника

        Returns:
           float: площадь прямоугольника (тип float)

        """
        return self.__length * self.__width

    def calculate_perimeter(self) -> float:
        """Расчитывает периметр прямоугольника

        Returns:
           float: периметр прямоугольника (тип float)

        """
        return 2 * (self.__length + self.__width)


rectangle = Rectangle(10, 5)
rectangle.set_value(10,2)
print(rectangle.get_value())
