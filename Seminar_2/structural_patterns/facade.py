# Класс для выполнения задачи A
class TaskA:
    def execute(self):
        print("Выполнение задачи A")

# Класс для выполнения задачи B


class TaskB:
    def execute(self):
        print("Выполнение задачи B")

# Класс для выполнения задачи C


class TaskC:
    def execute(self):
        print("Выполнение задачи C")

# Фасад


class Facade:
    def __init__(self):
        self.task_a = TaskA()
        self.task_b = TaskB()
        self.task_c = TaskC()

    def do_all_tasks(self):
        self.task_a.execute()
        self.task_b.execute()
        self.task_c.execute()


if __name__ == "__main__":
    facade = Facade()
    facade.do_all_tasks()
