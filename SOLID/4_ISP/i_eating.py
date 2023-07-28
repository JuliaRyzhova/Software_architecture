from abc import ABC, abstractmethod


class IEating(ABC):
    @abstractmethod
    def eat(self):
        raise NotImplementedError(
            'В дочернем классе должен быть переопределен метод aet()')
