from cached_order_repository import CachedOrderRepository
from product import Product
from order import Order
from order_item import OrderItem


product_store = CachedOrderRepository('shop.db')

product_1 = Product(id=1, name='Война и мир', price=550.50, count=100)
product_2 = Product(id=2, name='Тетрадь в клетку', price=10.90, count=500)

# product_store.add_product(product_1)
# product_store.add_product(product_2)

order_1 = Order()

order_item_1 = OrderItem(product=product_1, quantity=5)
order_item_2 = OrderItem(product=product_2, quantity=8)

product_store.save(order=order_1, order_items=[order_item_1, order_item_2])

product_store.get_last_order()
