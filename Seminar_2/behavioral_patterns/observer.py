# Интерфейс для наблюдателя
class Observer:
    def update(self):
        pass

# Интерфейс для субъекта (наблюдаемого объекта)


class Subject:
    def add_observer(self, observer):
        pass

    def remove_observer(self, observer):
        pass

    def notify_observers(self):
        pass
# Конкретный наблюдатель


class ConcreteObserver(Observer):
    def __init__(self, name):
        self.name = name

    def update(self):
        print(f"{self.name}: Получено уведомление об изменениях!")

# Конкретный субъект (наблюдаемый объект)


class ConcreteSubject(Subject):
    def __init__(self):
        self.observers = []

    def add_observer(self, observer):
        self.observers.append(observer)

    def remove_observer(self, observer):
        self.observers.remove(observer)

    def notify_observers(self):
        for observer in self.observers:
            observer.update()

    # Метод, который вызывается при изменении состояния субъекта
    def do_something(self):
        # Логика изменения состояния субъекта
        # ...
        # Уведомляем наблюдателей об изменениях
        self.notify_observers()


if __name__ == "__main__":
    subject = ConcreteSubject()

    observer1 = ConcreteObserver("Наблюдатель 1")
    observer2 = ConcreteObserver("Наблюдатель 2")

    subject.add_observer(observer1)
    subject.add_observer(observer2)

    # Вызываем метод, который меняет состояние субъекта и уведомляет наблюдателей
    subject.do_something()
