from abc import ABC, abstractmethod


class IGreet(ABC):
    @abstractmethod
    def greet(self):
        raise NotImplementedError('В дочернем классе должен быть переопределен метод greet()')
