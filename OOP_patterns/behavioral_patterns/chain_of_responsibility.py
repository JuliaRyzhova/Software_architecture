from __future__ import annotations
from abc import ABC, abstractmethod
from typing import Any, Optional

# Цепочка обязанностей — это поведенческий паттерн проектирования, который позволяет передавать
# запросы последовательно по цепочке обработчиков. Каждый последующий
# обработчик решает, может ли он обработать запрос сам и стоит ли передавать запрос дальше по цепи.


class Handler(ABC):
    """
    Интерфейс Обработчик определяет общий для всех конкретных обработчиков интерфейс. Обычно достаточно описать 
    единственный метод обработки запросов, но иногда здесь может быть объявлен и метод выставления следующего обработчика..
    """

    @abstractmethod
    def set_next(self, handler: Handler) -> Handler:
        pass

    @abstractmethod
    def handle(self, request) -> Optional[str]:
        pass


class AbstractHandler(Handler):
    """
    Базовый обработчик — опциональный класс, который позволяет избавиться от дублирования одного и того же кода 
    во всех конкретных обработчиках.

    Обычно этот класс имеет поле для хранения ссылки на следующий обработчик в цепочке. 

    Клиент связывает обработчики в цепь, подавая ссылку на следующий обработчик через конструктор или сеттер поля. 
    Также здесь можно реализовать базовый метод обработки, который бы просто перенаправлял запрос следующему обработчику, 
    проверив его наличие.
    """

    _next_handler: Handler = None

    def set_next(self, handler: Handler) -> Handler:
        self._next_handler = handler
        # Возврат обработчика отсюда позволит связать обработчики простым
        # способом, вот так:
        # monkey.set_next(squirrel).set_next(dog)
        return handler

    @abstractmethod
    def handle(self, request: Any) -> str:
        if self._next_handler:
            return self._next_handler.handle(request)

        return None


"""
Все Конкретные Обработчики либо обрабатывают запрос, либо передают его
следующему обработчику в цепочке.
"""


class MonkeyHandler(AbstractHandler):
    """ 
    Конкретные обработчики содержат код обработки запросов. 
    При получении запроса каждый обработчик решает, может ли он обработать запрос, 
    а также стоит ли передать его следующему объекту.

    В большинстве случаев обработчики могут работать сами по себе и быть неизменяемыми, 
    получив все нужные детали через параметры конструктора.
"""

    def handle(self, request: Any) -> str:
        if request == "Banana":
            return f"Monkey: I'll eat the {request}"
        else:
            return super().handle(request)


class SquirrelHandler(AbstractHandler):
    def handle(self, request: Any) -> str:
        if request == "Nut":
            return f"Squirrel: I'll eat the {request}"
        else:
            return super().handle(request)


class DogHandler(AbstractHandler):
    def handle(self, request: Any) -> str:
        if request == "MeatBall":
            return f"Dog: I'll eat the {request}"
        else:
            return super().handle(request)


def client_code(handler: Handler) -> None:
    """
    Обычно клиентский код приспособлен для работы с единственным обработчиком. В
    большинстве случаев клиенту даже неизвестно, что этот обработчик является
    частью цепочки.
    """

    for food in ["Nut", "Banana", "Cup of coffee"]:
        print(f"\nClient: Who wants a {food}?")
        result = handler.handle(food)
        if result:
            print(f"  {result}", end="")
        else:
            print(f"  {food} was left untouched.", end="")


if __name__ == "__main__":
    monkey = MonkeyHandler()
    squirrel = SquirrelHandler()
    dog = DogHandler()

    monkey.set_next(squirrel).set_next(dog)

    # Клиент должен иметь возможность отправлять запрос любому обработчику, а не
    # только первому в цепочке.
    print("Chain: Monkey > Squirrel > Dog")
    client_code(monkey)
    print("\n")

    print("Subchain: Squirrel > Dog")
    client_code(squirrel)
