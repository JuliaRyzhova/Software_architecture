from i_print import IPrint
from i_data import IData


class Printer(IPrint):
    def print(self, data: IData) -> None:
        print(data.get_data())
