from src.model.circle import Circle
from src.model.rectangle import Rectangle

circle = Circle(5)
print(circle.get_radius())
circle.set_radius(10)
print(circle.get_radius())

rectangle = Rectangle(10, 15)
print(rectangle.get_values())
