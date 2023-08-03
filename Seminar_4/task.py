class Calculator:
    def add(self, a: float, b: float) -> float:
        """
        Выполняет сложение двух чисел.

        :param a: первое число (слагаемое)
        :param b: второе число (слагаемое)
        :return: сумма двух чисел
        """
        return a + b

    def subtract(self, a: float, b: float) -> float:
        """
        Выполняет вычитание одного числа из другого.

        :param a: число, из которого вычитаем
        :param b: число, которое вычитаем
        :return: разность двух чисел
        """
        return a - b

    def multiply(self, a: float, b: float) -> float:
        """
        Выполняет умножение двух чисел.

        :param a: первый множитель
        :param b: второй множитель
        :return: произведение двух чисел
        """
        return a * b

    def divide(self, a: float, b: float) -> float:
        """
        Выполняет деление одного числа на другое.

        :param a: делимое
        :param b: делитель
        :return: частное от деления двух чисел
        :raises ZeroDivisionError: если делитель равен нулю
        """
        if b == 0:
            raise ZeroDivisionError("Cannot divide by zero.")
        return a / b
    

    