from abc import ABC, abstractmethod


class IArea(ABC):
    @abstractmethod
    def get_area(self):
        raise NotImplementedError('В дочернем классе должен быть переопределен метод get_area()')
