class Book:
    """Сущность книга"""
    def __init__(self, book_id, title, author, price, count_book, year_release):
        self.book_id = None
        self.title = title
        self.author = author
        self.price = price
        self.count_book = count_book
        self.year_release = year_release

        