"""Необходимо исправить нарушение 5-го принципа SOLID"""
"""1. Dependency inversion principle - Принцип инверсии зависимостей. 
Наши классы должны зависеть от интерфейсов или абстрактных классов, а не конкретных классов и функций. 

- модули высоко уровня не должны зависеть от модулей нижнего уровня. И те и другие должны зависеть от абстракций.
- абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций."""


class Text:
    def __init__(self, text: str):
        self.text = text

    def get_text(self) -> str:
        return self.text


class Printer:
    def print(self, text: Text) -> None:
        print(text.get_text())


if __name__ == '__main__':
    mytext = Text('Hello, world')
    myprinter = Printer()
    myprinter.print(mytext)
