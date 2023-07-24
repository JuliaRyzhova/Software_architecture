# Интерфейс компонента
class Component:
    def operation(self):
        pass

# Конкретный компонент (лист)


class Leaf(Component):
    def __init__(self, name):
        self.name = name

    def operation(self):
        print(f"Выполнение операции для Leaf {self.name}")

# Компоновщик (Composite)


class Composite(Component):
    def __init__(self):
        self.components = []

    def add_component(self, component):
        self.components.append(component)

    def remove_component(self, component):
        self.components.remove(component)

    def operation(self):
        print("Выполнение операции для Composite")
        for component in self.components:
            component.operation()


if __name__ == "__main__":
    # Создание листьев
    leaf1 = Leaf("Лист 1")
    leaf2 = Leaf("Лист 2")

    # Создание компоновщиков
    composite1 = Composite()
    composite2 = Composite()

    # Добавление листьев в компоновщик 1
    composite1.add_component(leaf1)
    composite1.add_component(leaf2)

    # Добавление компоновщика 1 в компоновщик 2
    composite2.add_component(composite1)

    # Выполнение операций
    leaf1.operation()       # Выведет: "Выполнение операции для Leaf Лист 1"
    leaf2.operation()       # Выведет: "Выполнение операции для Leaf Лист 2"
    composite1.operation()  # Выведет: "Выполнение операции для Composite", "Выполнение операции для Leaf Лист 1", "Выполнение операции для Leaf Лист 2"
    composite2.operation()  # Выведет: "Выполнение операции для Composite", "Выполнение операции для Leaf Лист 1", "Выполнение операции для Leaf Лист 2"
