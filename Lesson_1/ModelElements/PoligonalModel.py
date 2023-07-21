from Poligon import Poligon
from Texture import Texture


class PoligonalModel:
    def __init__(self, Poligons: Poligon, Textures: Texture) -> None:
        self.Poligons = Poligons
        self.Textures = Textures
