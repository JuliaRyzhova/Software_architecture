from abc import ABC, abstractmethod


class IModelChanger(ABC):
    @abstractmethod
    def NotifyChange(data: IModelChangersender) -> None:
        pass
