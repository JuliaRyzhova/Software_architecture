from abc import ABC, abstractmethod


class IWorking(ABC):
    @abstractmethod
    def work(self):
        raise NotImplementedError(
            'В дочернем классе должен быть переопределен метод work()')
