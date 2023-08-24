from typing import Optional
from cachetools import cached, TTLCache
from order_repository_impl import OrderRepositoryImpl
from order import Order


class CachedOrderRepository(OrderRepositoryImpl):
    """Реализация класса репозитория заказов с кэшированием.

    Args:
        OrderRepositoryImpl: Класс работы с рпеозиторием заказов
    """
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)


    @cached(cache= TTLCache(maxsize= 33, ttl = 600))
    def get_last_order(self)-> Optional[Order]:
        """
        Получает последний заказ из кэша, если он существует. В противном случае, получает его из базы данных
        и сохраняет в кэше.

        :return: Последний заказ или None, если заказы отсутствуют.
        """
        return super().get_last_order()
    
    
