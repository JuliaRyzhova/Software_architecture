from i_area import IArea


class Square(IArea):
    def __init__(self, width):
        self.width = width

    def get_area(self):
        return self.width * self.width
