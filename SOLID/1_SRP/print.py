from book import Book


class Print:
    def print_book(self, book: Book):
        print(
            f"Печать книги '{book.get_title()}' автора '{book.get_title()}'.")
