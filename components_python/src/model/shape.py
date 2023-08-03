from abc import ABC, abstractmethod


class Shape(ABC):
    """
    Абстрактный класс геометрической фигуры

    Методы:
        - calculate_area(self) : расчитывает площадь геометрической фигуры
        - calculate_perimeter(self): расчитывает периметр геометрической фигуры
    """
    @abstractmethod
    def calculate_area(self):
        """ Метод расчета площади геометрической фигуры

        Raises:
            NotImplementedError: В дочернем классе должен быть переопределен метод calculateArea()
        """
        raise NotImplementedError(
            ('В дочернем классе должен быть переопределен метод calculate_area()'))

    @abstractmethod
    def calculate_perimeter(self):
        """ Метод расчета периметра геометрической фигуры

        Raises:
            NotImplementedError: В дочернем классе должен быть переопределен метод calculatePerimeter()
        """
        raise NotImplementedError(
            ('В дочернем классе должен быть переопределен метод calculate_perimeter()'))
