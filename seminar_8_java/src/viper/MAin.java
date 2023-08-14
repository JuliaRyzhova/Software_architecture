package viper;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

// Интерфейс View, который определяет методы для отображения задач
interface TaskListView {
    void showTasks(List<Task> tasks);
    void showTaskDetails(Task task);
}

// Класс ConsoleTaskListView реализует интерфейс TaskListView для консольного вывода
class ConsoleTaskListView implements TaskListView {
    @Override
    public void showTasks(List<Task> tasks) {
        System.out.println("Список задач:");
        for (Task task : tasks) {
            System.out.println(task.getTitle());
        }
    }

    @Override
    public void showTaskDetails(Task task) {
        System.out.println("Детали задачи:");
        System.out.println("Заголовок: " + task.getTitle());
        System.out.println("Статус: " + (task.isCompleted() ? "Выполнено" : "Не выполнено"));
    }
}
   // Компонент Interactor

// Класс TaskListInteractor отвечает за бизнес-логику и получение данных
class TaskListInteractor {
    private TaskRepository repository;

    public TaskListInteractor(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getTasks() {
        return repository.getTasks();
    }
}

// Интерфейс TaskRepository определяет метод для получения задач
interface TaskRepository {
    List<Task> getTasks();
}

// Класс InMemoryTaskRepository реализует интерфейс TaskRepository и предоставляет список задач в памяти
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
    // Компонент Presenter

// Класс TaskListPresenter связывает View и Interactor, обрабатывает данные и события
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
    // Компонент Entity

// Класс Task представляет основные данные задачи
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
    // Компонент Router

// Класс TaskListRouter отвечает за навигацию между модулями
class TaskListRouter {
    private Context context;

    public TaskListRouter(Context context) {
        this.context = context;
    }

    public void navigateToTaskDetails(Task task) {
        // Реализация навигации к деталям задачи
        System.out.println("Навигация к деталям задачи: " + task.getTitle());
    }
}
    // Главный класс (Main)

// Главный класс Main, где создаются экземпляры всех компонентов
class Main {
    public static void main(String[] args) {
        TaskListView view = new ConsoleTaskListView();
        TaskRepository repository = new InMemoryTaskRepository();
        TaskListInteractor interactor = new TaskListInteractor(repository);

        Context context = null;
        TaskListRouter router = new TaskListRouter(context);

        TaskListPresenter presenter = new TaskListPresenter(view, interactor);
        presenter.loadTasks();

        Task selectedTask = new Task("Помыть посуду"); // Пример выбора задачи
        presenter.onTaskSelected(selectedTask);
    }
}