from abc import ABC, abstractmethod
from i_data import IData


class IPrint(ABC):
    @abstractmethod
    def print(self, data: IData) -> None:
        raise NotImplementedError(
            'В дочернем классе должен быть переопределен метод print()')
