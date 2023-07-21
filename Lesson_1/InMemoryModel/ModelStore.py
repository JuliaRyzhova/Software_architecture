from ModelElements.PoligonalModel import PoligonalModel
from ModelElements.Scene import Scene
from ModelElements.Flash import Flash
from ModelElements.Camera import Camera
from IModelChangeObserver import IModelChangeObserver
from IModelChanger import IModelChanger


class ModelStore(IModelChanger, IModelChangeObserver):
    """Класс ModelStore

    Args:
        IModelChanger : наследует метод NotifyChange абстрактного класса IModelChanger
        IModelChangeObserver : принимает в себя атрибут типа IModelChangeObserver

    Attributes:
        Models - (public) поле типа Model
        Scenes - (public) поле типа Scene
        Flashes - (public) поле типа Flash
        Cameras - (public) поле типа Camera
        __changeObservers - (private) поле типа IModelChangeObserver

    Methods:
        GetScena(int) - 
        NotifyChange(IModelChanger) - 
    """

    def __init__(self,
                 Models: PoligonalModel,
                 Scenes: Scene,
                 Flashes: Flash,
                 Cameras: Camera,
                 changeObservers: IModelChangeObserver) -> None:
        self.Models = Models
        self.Scenes = Scenes
        self.Flashes = Flashes
        self.Cameras = Cameras
        self.__changeObservers = changeObservers

    def GetScena(data: int) -> Scene:
        return data

    def NotifyChange(data: IModelChanger) -> None:
        pass
