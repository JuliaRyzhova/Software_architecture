from shape import Shape


class Square(Shape):
    """Класс геометрической фигуры 'Квадрат' наследник класса 'Shape'

    Атрибуты:
    - __side (float): длина стороны квадрата (должна быть положительным числом)

    Методы:
    - __init__(side: float): конструктор класса Sruare
    - __check_value(side: float) -> bool: проверяет корректность введенных данных
    - get_value() -> float: возвращает длину стороны квадрата
    - set_value(side: float): устанавливает длину стороны квадрата
    - calculate_area() -> float: вычисляет площадь квадрата
    - calculate_perimeter() -> float: вычисляет периметр квадрата
    """

    def __init__(self, side: float) -> None:
        """Конструктор - создание нового экземпляра класса Square

        Args:
        - side (float): длина стороны квадрата (должна быть положительным числом)

        """
        if self.__check_value(side):
            self.__side = side

    @staticmethod
    def __check_value(side: float) -> bool:
        """Проверяет корректность введенных данных

        Returns:
        - True - если длина стороны квадрата >0
        - False - если длина стороны квадрата <0 или не число
        """
        return (
            isinstance(side, (int, float)) and
            side >= 0
        )

    def get_value(self) -> float:
        """Доступ к полю side объекта класса Square. Возвращает длину стороны квадрата

        Returns:
            side(float): Длину стороны квадрата
        """
        return self.__side

    def set_value(self, side: float) -> None:
        """
        Устанавливает значения длины стороны квадрата.

        Args:
        - side (float): длина стороны квадрата (должна быть положительным числом)


        Возможные исключения:
            - ValueError: выбрасывается, если длина стороны квадрата <0 или не число
        """
        if self.__check_value(side):
            self.__side = side
        else:
            raise ValueError(
                "Сторона квадрата должна быть положительным числом")

    def calculate_area(self) -> float:
        """Расчитывает площадь квадрата

        Returns:
           float: площадь квадрата (тип float)

        """
        return self.__side * self.__side

    def calculate_perimeter(self) -> float:
        """Расчитывает периметр квадрата

        Returns:
           float: периметр квадрата (тип float)

        """
        return 4 * self.__side
