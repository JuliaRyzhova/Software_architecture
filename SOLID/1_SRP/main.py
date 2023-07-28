from book import Book
from print import Print
from save import Save


if __name__ == "__main__":
    book = Book("Властелин Колец", "Толкин")
    printer = Print()
    saver = Save()
    saver.save(book)
    printer.print_book(book)
