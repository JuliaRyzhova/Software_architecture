from PoligonalModel import PoligonalModel
from Flash import Flash


class Scene:
    def __init__(self, id: int, models: PoligonalModel, flashes: Flash) -> None:
        self.id = id
        self.models = models
        self.flashes = flashes

    def method_1(data: None) -> None:
        pass

    def method_2(data1: None, data2: None) -> None:
        pass
