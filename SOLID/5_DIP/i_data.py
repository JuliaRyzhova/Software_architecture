from abc import ABC, abstractmethod


class IData(ABC):
    @abstractmethod
    def get_data(self):
        raise NotImplementedError(
            'В дочернем классе должен быть переопределен метод get_data()')
