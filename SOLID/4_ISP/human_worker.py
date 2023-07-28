from i_eating import IEating
from i_working import IWorking


class HumanWorker(IEating, IWorking):
    def work(self) -> None:
        print('Человек работает')

    def eat(self) -> None:
        print('Человек ест')
