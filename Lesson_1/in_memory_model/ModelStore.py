from ModelElements.PoligonalModel import PoligonalModel
from ModelElements.Scene import Scene
from ModelElements.Flash import Flash
from ModelElements.Camera import Camera
from IModelChangeObserver import IModelChangeObserver
from IModelChanger import IModelChanger


class modelstore(IModelChanger):
    """Класс modelstore

    Args:
        IModelChanger : наследует метод NotifyChange абстрактного класса IModelChanger

    Attributes:
        models - (public) поле типа Model
        scenes - (public) поле типа Scene
        flashes - (public) поле типа Flash
        cameras - (public) поле типа Camera
        __changeObservers - (private) поле типа IModelChangeObserver

    Methods:
        get_scena(int) - 
        notify_change(IModelChanger) - 
    """

    def __init__(self,
                 models: PoligonalModel,
                 scenes: Scene,
                 flashes: Flash,
                 cameras: Camera,
                 changeObservers: IModelChangeObserver) -> None:
        self.models = models
        self.scenes = scenes
        self.flashes = flashes
        self.cameras = cameras
        self.__changeObservers = changeObservers

    def get_scena(data: int) -> Scene:
        return data

    def notify_change(data: IModelChanger) -> None:
        pass
