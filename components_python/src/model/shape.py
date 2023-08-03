from abc import ABC, abstractmethod


class Shape(ABC):
    """Абстрактный класс геометрической фигуры"""
    @abstractmethod
    def calculate_area(self):
        """ Метод расчета площади фигуры
        Raises:
            NotImplementedError: В дочернем классе должен быть переопределен метод calculateArea()
        """
        raise NotImplementedError(
            ('В дочернем классе должен быть переопределен метод calculateArea()'))

    @abstractmethod
    def calculate_perimeter(self):
        """ Метод расчета периметра фигуры

        Raises:
            NotImplementedError: В дочернем классе должен быть переопределен метод calculatePerimeter()
        """
        raise NotImplementedError(
            ('В дочернем классе должен быть переопределен метод calculatePerimeter()'))
