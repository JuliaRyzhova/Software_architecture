package mvvm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Model

class Book {
    private String title;
    private boolean isRead;

    public Book(String title) {
        this.title = title;
        this.isRead = false;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    public boolean isRead() {
        return isRead;
    }

    @Override
    public String toString() {
        return title + (isRead ? " (прочитана)" : " (не прочитана)");
    }
}
    //ViewModel будет обеспечивать форматированный вывод списка книг и предоставлять методы для
    // маркировки книг как прочитанных.


// ViewModel



class BooksViewModel {
    private final List<Book> books;

    public BooksViewModel(List<Book> books) {
        this.books = books;
    }

    public String getDisplayableBooks() {
        StringBuilder builder = new StringBuilder("Список книг:\n");
        for (int i = 0; i < books.size(); i++) {
            builder.append((i + 1)).append(". ").append(books.get(i).toString()).append("\n");
        }
        return builder.toString();
    }

    public void markBookAsRead(int index) {
        books.get(index).markAsRead();
    }
}
    // View будет обеспечивать интерактивный интерфейс для пользователя, чтобы он мог отмечать книги как прочитанные.


// View



class MVVMPatternDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Властелин Колец"));
        books.add(new Book("1984"));
        books.add(new Book("Убить пересмешника"));

        BooksViewModel viewModel = new BooksViewModel(books);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(viewModel.getDisplayableBooks());
            System.out.println("Введите номер книги, чтобы отметить ее как прочитанную (или 'exit' для выхода): ");

            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                int bookId = Integer.parseInt(input) - 1;
                viewModel.markBookAsRead(bookId);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите номер книги.");
            }
        }
    }
}
