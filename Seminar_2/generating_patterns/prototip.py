# Абстрактный класс Прототипа
class Prototype:
    def clone(self):
        pass

# Конкретный класс Прототипа


class ConcretePrototype(Prototype):
    def __init__(self, property):
        self.property = property

    def clone(self):
        return ConcretePrototype(self.property)

    def set_property(self, property):
        self.property = property

    def get_property(self):
        return self.property


# Клиентский код
if __name__ == "__main__":
    # Создаем и инициализируем прототип
    prototype = ConcretePrototype("Пример")

    # Создаем новый объект путем клонирования прототипа
    clone1 = prototype.clone()
    print("Клон 1:", clone1.get_property())

    # Меняем свойство клонированного объекта
    clone1.set_property("Измененный пример")
    print("Клон 1 (после изменения):", clone1.get_property())

    # Создаем еще один новый объект путем клонирования прототипа
    clone2 = prototype.clone()
    print("Клон 2:", clone2.get_property())
