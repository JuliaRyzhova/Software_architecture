from PoligonalModel import PoligonalModel
from Flash import Flash


class Scene:
    def __init__(self, id: int, Models: PoligonalModel, Flashes: Flash) -> None:
        self.id = id
        self.Models = Models
        self.Flashes = Flashes

    def method1(data: None) -> None:
        pass

    def method2(data1: None, data2: None) -> None:
        pass
