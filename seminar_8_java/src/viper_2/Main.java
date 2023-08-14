package viper_2;

import java.util.*;

// --- Entity ---

/**
 * Класс Task представляет сущность задачи с заголовком и статусом выполнения.
 */
class Task {
    private String title;
    private boolean completed;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

// --- Interactor ---

/**
 * Интерфейс TaskRepository определяет методы для работы с репозиторием задач.
 */
interface TaskRepository {
    List<Task> getTasks();
}

/**
 * InMemoryTaskRepository - реализация TaskRepository для хранения задач в памяти.
 */
class InMemoryTaskRepository implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    public InMemoryTaskRepository() {
        tasks.add(new Task("Помыть посуду"));
        tasks.add(new Task("Постирать белье"));
    }

    @Override
    public List<Task> getTasks() {
        return tasks;
    }
}

/**
 * TaskListInteractor отвечает за бизнес-логику и взаимодействие с репозиторием.
 */
class TaskListInteractor {
    private TaskRepository repository;

    public TaskListInteractor(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getTasks() {
        return repository.getTasks();
    }
}

// --- View ---

/**
 * Интерфейс TaskListView определяет контракт для отображения задач.
 */
interface TaskListView {
    void showTasks(List<Task> tasks);
    void showTaskDetails(Task task);
}

/**
 * ConsoleTaskListView - реализация TaskListView для вывода информации в консоль.
 */
class ConsoleTaskListView implements TaskListView {
    @Override
    public void showTasks(List<Task> tasks) {
        System.out.println("Список задач:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTitle());
        }
    }


    @Override
    public void showTaskDetails(Task task) {
        System.out.println("Детали задачи:");
        System.out.println("Заголовок: " + task.getTitle());
        System.out.println("Статус: " + (task.isCompleted() ? "Выполнено" : "Не выполнено"));
    }
}

// --- Presenter ---

/**
 * TaskListPresenter связывает View и Interactor, обрабатывает взаимодействие и передает данные.
 */
class TaskListPresenter {
    private TaskListView view;
    private TaskListInteractor interactor;

    public TaskListPresenter(TaskListView view, TaskListInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    public void loadTasks() {
        List<Task> tasks = interactor.getTasks();
        view.showTasks(tasks);
    }

    public void onTaskSelected(Task task) {
        view.showTaskDetails(task);
    }
}

// --- Router ---

/**
 * TaskListRouter отвечает за навигацию между экранами или модулями.
 */
class TaskListRouter {
    public void navigateToTaskDetails(Task task) {
        // Здесь могла бы быть реализация навигации к другому экрану или модулю.
        // В текущей версии просто выводим сообщение в консоль.
        System.out.println("Навигация к деталям задачи: " + task.getTitle());
    }
}

// --- Main class ---

/**
 * Главный класс, где создаются и связываются все компоненты.
 */
public class Main {
    public static void main(String[] args) {
        TaskRepository repository = new InMemoryTaskRepository();
        TaskListInteractor interactor = new TaskListInteractor(repository);

        TaskListView view = new ConsoleTaskListView();
        TaskListPresenter presenter = new TaskListPresenter(view, interactor);

        TaskListRouter router = new TaskListRouter();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    presenter.loadTasks();
                    break;
                case 2:
                    handleTaskSelection(scanner, interactor, presenter);
                    break;
                case 3:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Показать все задачи");
        System.out.println("2. Показать детали задачи");
        System.out.println("3. Выйти");
        System.out.print("Выберите действие: ");
    }

    private static void handleTaskSelection(Scanner scanner, TaskListInteractor interactor, TaskListPresenter presenter) {
        List<Task> tasks = interactor.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTitle());
        }

        System.out.print("Введите номер задачи: ");
        int taskIndex = scanner.nextInt();

        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Task selectedTask = tasks.get(taskIndex - 1);
            presenter.onTaskSelected(selectedTask);
        } else {
            System.out.println("Такой задачи нет.");
        }
    }
}