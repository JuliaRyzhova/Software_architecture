from abc import ABC, abstractmethod

class OrderRepository(ABC):

    @abstractmethod
    def init_database(self):
        pass

    @abstractmethod
    def save(self):
        pass

    @abstractmethod
    def get_last_order(self):
        pass

