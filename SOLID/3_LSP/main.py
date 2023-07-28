from square import Square
from rectangle import Rectangle

if __name__ == "__main__":
    rect = Rectangle(5, 10)
    square = Square(10)

    print(rect.get_area())
    print(square.get_area())
