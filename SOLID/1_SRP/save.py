from book import Book


class Save:
    def save(self, book: Book) -> None:
        print(
            f"Сохранение информации о книге '{book.get_title()}' в базе данных.")
