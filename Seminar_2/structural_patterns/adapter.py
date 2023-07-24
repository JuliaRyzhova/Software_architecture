# Устаревший интерфейс
class OldSystem:
    def request(self):
        print("Вызов устаревшего метода OldSystem.request()")
# Новый интерфейс


class NewSystem:
    def specific_request(self):
        print("Вызов нового метода NewSystem.specific_request()")
# Адаптер, который преобразует OldSystem к NewSystem


class Adapter(NewSystem):
    def __init__(self, old_system):
        self.old_system = old_system

    def specific_request(self):
        self.old_system.request()


if __name__ == "__main__":
    old_system = OldSystem()
    new_system = NewSystem()

    # Используем OldSystem через адаптер в новой системе
    adapter_system = Adapter(old_system)

    new_system.specific_request()
    adapter_system.specific_request()
