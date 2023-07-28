"""Необходимо исправить нарушение 4-го принципа SOLID ISP"""

"""Interface segregation principle - Принцип разделения интерфейса. 
Нужно создавать узкоспециализированные интерфейсы, предназначенные для конкретного клиента. 
Клиенты не должны реализовывать интерфейсы, которые они не используют
Не нужно создавать один интерфейс, реализующий много методов - т.к. все эти методы должны быть 
реализованы в дочерних классах, а они им могут быть не нужны. Проще создать несколько узкоспециализированных 
интерфейсов с одним методом для соответствующих классов."""


class Worker:
    def work(self):
        pass

    def eat(self):
        pass


class HumanWorker(Worker):
    def work(self):
        print('Человек работает')

    def eat(self):
        print('Человек ест')


class RobotWorker(Worker):
    def work(self):
        print('Робот работает')

    def eat(self):
        raise NotImplementedError('Роботы не едят!')


if __name__ == '__main__':
    worker = RobotWorker()
    worker.work()
    worker.eat()
