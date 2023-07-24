# Интерфейс для кофе
class Coffee:
    def get_cost(self):
        pass

    def get_description(self):
        pass

# Конкретная реализация базового кофе


class SimpleCoffee(Coffee):
    def get_cost(self):
        return 2.0

    def get_description(self):
        return "Простой кофе"

# Декоратор для добавления молока


class MilkDecorator(Coffee):
    def __init__(self, coffee):
        self._coffee = coffee

    def get_cost(self):
        return self._coffee.get_cost() + 0.5

    def get_description(self):
        return self._coffee.get_description() + ", с молоком"

# Декоратор для добавления шоколада


class ChocolateDecorator(Coffee):
    def __init__(self, coffee):
        self._coffee = coffee

    def get_cost(self):
        return self._coffee.get_cost() + 1.0

    def get_description(self):
        return self._coffee.get_description() + ", с шоколадом"


if __name__ == "__main__":
    simple_coffee = SimpleCoffee()
    print("Простой кофе:", simple_coffee.get_description(),
          "стоимость:", simple_coffee.get_cost())

    coffee_with_milk = MilkDecorator(simple_coffee)
    print("Кофе с молоком:", coffee_with_milk.get_description(),
          "стоимость:", coffee_with_milk.get_cost())

    coffee_with_milk_and_chocolate = ChocolateDecorator(coffee_with_milk)
    print("Кофе с молоком и шоколадом:", coffee_with_milk_and_chocolate.get_description(
    ), "стоимость:", coffee_with_milk_and_chocolate.get_cost())
