from abc import ABC, abstractmethod


class ShapeView(ABC):
    """
    Абстрактный класс представления методов геометрических фигур 

    Методы:
        - show_area(self) : визуализирует результат расчета площади геометрической фигуры
        - show_perimeter(self): визуализирует результат расчета периметра геометрической фигуры
    """

    def show_area(self):
        """ Метод визуализизация результата расчета площади геометрической фигуры

        Raises:
            NotImplementedError: В дочернем классе должен быть переопределен метод show_area()
        """
        raise NotImplementedError(
            ('В дочернем классе должен быть переопределен метод show_area()'))

    def show_perimeter(self):
        """ Метод визуализизация результата расчета ппериметра геометрической фигуры

        Raises:
            NotImplementedError: В дочернем классе должен быть переопределен метод show_perimeter()
        """
        raise NotImplementedError(
            ('В дочернем классе должен быть переопределен метод show_perimeter()'))
