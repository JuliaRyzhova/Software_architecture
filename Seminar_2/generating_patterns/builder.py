# Класс продукта, который мы будем строить
class Product:
    def __init__(self):
        self.partA = None
        self.partB = None
        self.partC = None

    def set_part_a(self, part_a):
        self.partA = part_a

    def set_part_b(self, part_b):
        self.partB = part_b

    def set_part_c(self, part_c):
        self.partC = part_c

    def display(self):
        print("PartA:", self.partA)
        print("PartB:", self.partB)
        print("PartC:", self.partC)

# Интерфейс для Строителя


class Builder:
    def build_part_a(self):
        pass

    def build_part_b(self):
        pass

    def build_part_c(self):
        pass

    def get_result(self):
        pass

# Конкретный класс Строителя


class ConcreteBuilder(Builder):
    def __init__(self):
        self.product = Product()

    def build_part_a(self):
        self.product.set_part_a("PartA of the product")

    def build_part_b(self):
        self.product.set_part_b("PartB of the product")

    def build_part_c(self):
        self.product.set_part_c("PartC of the product")

    def get_result(self):
        return self.product

# Директор, который управляет Строителем


class Director:
    def __init__(self, builder):
        self.builder = builder

    def construct(self):
        self.builder.build_part_a()
        self.builder.build_part_b()
        self.builder.build_part_c()


# Клиентский код
if __name__ == "__main__":
    builder = ConcreteBuilder()
    director = Director(builder)
    director.construct()

    product = builder.get_result()
    product.display()
