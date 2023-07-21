from abc import ABC, abstractmethod


class IModelChangeObserver(ABC):
    @abstractmethod
    def ApllyUpdateModel() -> None:
        pass
