# Интерфейс для продукта
class Product:
    def display(self):
        pass

# Конкретный класс продукта


class ConcreteProduct(Product):
    def display(self):
        print("Это конкретный продукт.")

# Абстрактный класс фабрики


class Creator:
    # Фабричный метод
    def create_product(self):
        pass

# Конкретный класс фабрики


class ConcreteCreator(Creator):
    def create_product(self):
        return ConcreteProduct()


# Клиентский код
if __name__ == "__main__":
    creator = ConcreteCreator()
    product = creator.create_product()
    product.display()  # Выведет: "Это конкретный продукт."
